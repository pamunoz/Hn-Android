package com.example.hnandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hnandroid.R
import com.example.hnandroid.ui.base.BaseActivity
import com.example.hnandroid.ui.viewmodule.HnStoriesViewModel
import com.example.hnandroid.utils.getViewModel

class MainActivity : BaseActivity() {

    private val hnStoriesViewModel by lazy { getViewModel<HnStoriesViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
