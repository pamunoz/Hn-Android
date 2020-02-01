package com.example.hnandroid.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hnandroid.R
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.model.HnStoriesAdapterEvent
import com.example.hnandroid.utils.inflate
import com.skybase.humanizer.DateHumanizer
import kotlinx.android.synthetic.main.row_hnstory.view.*
import java.text.SimpleDateFormat
import java.util.*


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
    override fun onBindViewHolder(holder: StoriesHolder, position: Int) = holder.bind(hnStories[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = hnStories.size

    /**
     * View Holder Pattern
     */
    class StoriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(hnStory: HnStories?, listener: (HnStoriesAdapterEvent) -> Unit) = with(itemView) {
            hnStory?.let {
                var simpleTitle = ""
                if (hnStory.storyTitle != null && hnStory.storyTitle.isNotEmpty()) {
                    simpleTitle = hnStory.storyTitle
                } else if(hnStory.title != null && hnStory.title.isNotEmpty()) {
                    simpleTitle = hnStory.title
                } else {
                    simpleTitle = "No Title Found"
                }


                var simpleDate: String

                tv_story_title.text = simpleTitle

                var dateTime = DateHumanizer.humanize(hnStory.createdAt, DateHumanizer.TYPE_PRETTY_EVERYTHING)
                simpleDate = when (dateTime) {
                    "Today" -> {
                        DateHumanizer.humanize(hnStory.createdAt, DateHumanizer.TYPE_DATE_DISABLE, DateHumanizer.TYPE_TIME_HH_MM)
                    }
                    "Yesterday" -> {
                        DateHumanizer.humanize(hnStory.createdAt, DateHumanizer.TYPE_PRETTY_EVERYTHING)
                    }
                    else -> {
                        DateHumanizer.humanize(hnStory.createdAt)
                    }
                }
                val footText = "${hnStory.author} - $simpleDate"
                tv_foot.text = footText
            }
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