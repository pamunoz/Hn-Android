package com.example.hnandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hnandroid.model.HnStoriesAdapterEvent

class HnStoriesAdapter(
    private val listener: (HnStoriesAdapterEvent) -> Unit
): RecyclerView.Adapter<HnStoriesAdapter.StoriesHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: StoriesHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class StoriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}