package com.example.hnandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hnandroid.R
import com.example.hnandroid.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val hnStoriesViewModel by lazy {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
