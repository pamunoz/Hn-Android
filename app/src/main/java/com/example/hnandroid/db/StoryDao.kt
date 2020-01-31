package com.example.hnandroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hnandroid.model.HnStory

/**
 * Defines access layer to news stories table
 */
@Dao
interface StoryDao {
    /**
     * Insert the story into the table
     */
    @Insert
    fun insertStories(articles: List<HnStory>): List<Long>

    /**
     * Get all the stories from table
     */
    @Query("SELECT * FROM hn_story")
    suspend fun getStories(): List<HnStory>

}