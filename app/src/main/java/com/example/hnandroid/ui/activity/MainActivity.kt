package com.example.hnandroid.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hnandroid.R
import com.example.hnandroid.ui.base.BaseActivity
import com.example.hnandroid.ui.viewmodule.HnStoriesViewModel
import com.example.hnandroid.utils.getViewModel
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
        rv_stories.layoutManager = linearLayoutManager
    }
}
