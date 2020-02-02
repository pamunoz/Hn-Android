package com.example.hnandroid.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hnandroid.R
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.ui.activity.StoryActivity
import com.example.hnandroid.utils.hnFormatDate
import com.example.hnandroid.utils.inflate
import kotlinx.android.synthetic.main.row_hnstory.view.*


class HnStoriesAdapter: RecyclerView.Adapter<HnStoriesAdapter.StoriesHolder>() {

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
        holder.bind(hnStories[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, StoryActivity::class.java)
            intent.putExtra("url", hnStories[position].storyUrl)
            it.context.startActivity(intent)
        }
    }

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = hnStories.size

    fun deleteItem(position: Int) {
        if (hnStories.isNullOrEmpty()) hnStories.drop(position)
    }

    fun getHnStoryAt(position: Int): HnStories {
        return hnStories.get(position)
    }

    /**
     * View Holder Pattern
     */
    class StoriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(hnStory: HnStories?) = with(itemView) {
            hnStory?.let {
                var simpleTitle: String = if (hnStory.storyTitle != null && hnStory.storyTitle.isNotEmpty()) {
                    hnStory.storyTitle
                } else if(hnStory.title != null && hnStory.title.isNotEmpty()) {
                    hnStory.title
                } else {
                    "No Title Found"
                }

                val footText = "${hnStory.author} - ${hnFormatDate(hnStory.createdAt)}"
                tv_story_title.text = simpleTitle
                tv_foot.text = footText
            }
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