package com.example.hnandroid.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hnandroid.R
import com.example.hnandroid.adapter.HnStoriesAdapter
import com.example.hnandroid.model.ViewState
import com.example.hnandroid.ui.base.BaseActivity
import com.example.hnandroid.ui.viewmodule.HnStoriesViewModel
import com.example.hnandroid.utils.getViewModel
import com.example.hnandroid.utils.observeNotNull
import com.example.hnandroid.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val hnStoriesViewModel by lazy { getViewModel<HnStoriesViewModel>() }

    private lateinit var linearLayoutManager: LinearLayoutManager

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, linearLayoutManager.orientation)
        rv_stories.addItemDecoration(divider)
        rv_stories.layoutManager = linearLayoutManager



        val hnStoriesAdapter = HnStoriesAdapter()
        rv_stories.adapter = hnStoriesAdapter

        // Update the UI on stage change
        hnStoriesViewModel.getHnStories().observeNotNull(this) {state ->
            when(state) {
                is ViewState.Success -> hnStoriesAdapter.replaceItems(state.data)
                is ViewState.Loading -> toast("Loading")
                is ViewState.Error -> {
                    toast("Something went wrong: ${state.message}")
                    Log.e("ANGOLIA:", "${state}")
                }
            }
        }
    }
}
