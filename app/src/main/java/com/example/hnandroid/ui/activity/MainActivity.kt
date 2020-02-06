package com.example.hnandroid.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hnandroid.R
import com.example.hnandroid.adapter.HnStoriesAdapter
import com.example.hnandroid.model.ViewState
import com.example.hnandroid.ui.base.BaseActivity
import com.example.hnandroid.ui.viewmodule.HnStoriesViewModel
import com.example.hnandroid.utils.getViewModel
import com.example.hnandroid.utils.observeNotNull
import com.example.hnandroid.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : BaseActivity() {

    private val hnStoriesViewModel by lazy { getViewModel<HnStoriesViewModel>() }

    private lateinit var linearLayoutManager: LinearLayoutManager
    val mAdapter = HnStoriesAdapter()
    /**
     * Starting point of the activity
     */
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure the refreshing colors
        swipe_container.setColorSchemeResources(android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        linearLayoutManager = LinearLayoutManager(this)

        rv_stories.apply {
            addItemDecoration(DividerItemDecoration(this@MainActivity, linearLayoutManager.orientation))
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }

        loadData(false)

        swipe_container.setOnRefreshListener { loadData(true) }

        setupSwipeToDelete()
    }

    /**
     * Setup refresh listener which triggers new data loading
     */
    private fun loadData(isReloading: Boolean) {
        // Update the UI on stage change
        hnStoriesViewModel.getHnStories().observeNotNull(this) {state ->
            when(state) {
                is ViewState.Success -> {
                    mAdapter.apply {
                        if (isReloading) clear()
                        addAll(state.data)
                    }
                    swipe_container.isRefreshing = false
                }
                is ViewState.Loading -> swipe_container.isRefreshing = true
                is ViewState.Error -> {
                    toast("Something went wrong: ${state.message}")
                    Log.e("ANGOLIA:", "${state}")
                }
            }
        }
    }

    private fun setupSwipeToDelete() {
        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT  or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: ViewHolder, target: ViewHolder
                ): Boolean {
                    val fromPos = viewHolder.adapterPosition
                    val toPos = target.adapterPosition
                    // move item in `fromPos` to `toPos` in adapter.
                    return false // true if moved, false otherwise
                }

                override fun onSwiped(
                    viewHolder: ViewHolder,
                    direction: Int
                ) { //
                    // remove from adapter
                    hnStoriesViewModel.deleteStory(mAdapter.getHnStoryAt(viewHolder.adapterPosition))
                }
            }).attachToRecyclerView(rv_stories)
    }
}
