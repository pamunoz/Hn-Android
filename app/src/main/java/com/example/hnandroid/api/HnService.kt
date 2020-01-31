package com.example.hnandroid.api

import com.example.hnandroid.model.StoriesSourceResponse
import retrofit2.http.GET

/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface HnService {

    /**
     * Retrieves all the latest news article from Google news using News API.
     */
    @GET("1/search_by_date?query=android ")
    suspend fun getStories(): StoriesSourceResponse

}