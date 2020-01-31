package com.example.hnandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hnandroid.R
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.model.HnStoriesAdapterEvent
import com.example.hnandroid.utils.inflate
import kotlinx.android.synthetic.main.row_hnstory.view.*

class HnStoriesAdapter(
    private val listener: (HnStoriesAdapterEvent) -> Unit
): RecyclerView.Adapter<HnStoriesAdapter.StoriesHolder>() {

    /**
     * List of hacker news tories
     */
    private var hnStories: List<HnStories> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StoriesHolder(parent.inflate(
        R.layout.row_hnstory))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(holder: StoriesHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    class StoriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(hnStory: HnStories, listener: (HnStoriesAdapterEvent) -> Unit) = with(itemView) {
            tv_story_title.text = hnStory.storyTitle
            val footText = "${hnStory.author} - ${hnStory.createdAt}"
            tv_foot.text = footText
            setOnClickListener { listener(HnStoriesAdapterEvent.ClickEvent) }
        }
    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<HnStories>) {
        hnStories = items
        notifyDataSetChanged()
    }
}