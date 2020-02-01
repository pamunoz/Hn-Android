package com.example.hnandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hnandroid.R
import com.example.hnandroid.utils.toast
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        wv_story.loadUrl(intent.getStringExtra("url"))
    }
}
