package com.example.hnandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hnandroid.model.HnStory.HnStory.tableName
import com.example.hnandroid.model.HnStory.HnStory.Column
import com.google.gson.annotations.SerializedName


/**
 * Hacker news Story Model describing the story details
 * fetched from news source.
 */
@Entity(tableName = tableName)
data class HnStory(
    /**
     * Primary key for Room.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    /**
     * Name of the author for the story
     */
    @ColumnInfo(name = Column.author)
    @SerializedName(Column.author)
    val author: String,
    /**
     * Time of being created as a string
     */
    @ColumnInfo(name = Column.created_at)
    @SerializedName(Column.created_at)
    val createdAt: String,
    /**
     * Time of being created as a integer
     */
    @ColumnInfo(name = Column.created_at_milis)
    @SerializedName(Column.created_at_milis)
    val createdAtI: Int,
//    /**
//     * The Id of the story
//     */
//    @ColumnInfo(name = Column.story_id)
//    @SerializedName(Column.story_id)
//    val storyId: Int,
    /**
     * The text of the story
     */
    @ColumnInfo(name = Column.story_text)
    @SerializedName(Column.story_text)
    val storyText: String,
    /**
     * The title of the story
     */
    @ColumnInfo(name = Column.story_title)
    @SerializedName(Column.story_title)
    val storyTitle: String,
    /**
     * The Url of the story
     */
    @ColumnInfo(name = Column.story_url)
    @SerializedName(Column.story_url)
    val storyUrl: String,
    /**
     * The title of the story
     */
    @ColumnInfo(name = Column.title)
    @SerializedName(Column.title)
    val title: String
) {
    object HnStory {
        const val tableName = "hn_story"

        object Column {
            const val id = "id"
            const val author = "author"
            const val created_at = "created_at"
            const val created_at_milis = "created_at_i"
            const val story_text = "story_text"
            const val story_title = "story_title"
            const val title = "title"
            const val story_url = "story_url"

        }
    }
}