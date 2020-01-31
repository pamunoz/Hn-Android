package com.example.hnandroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hnandroid.model.HnStories

/**
 * Defines access layer to news stories table
 */
@Dao
interface HnStoriesDao {
    /**
     * Insert the story into the table
     */
    @Insert
    fun insertStories(articles: List<HnStories>): List<Long>

    /**
     * Get all the stories from table
     */
    @Query("SELECT * FROM hn_story")
    suspend fun getStories(): List<HnStories>

}