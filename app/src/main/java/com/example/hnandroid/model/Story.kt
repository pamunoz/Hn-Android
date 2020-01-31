package com.example.hnandroid.model

import com.google.gson.annotations.SerializedName

data class Story(
    @SerializedName("author")
    val author: String,
    @SerializedName("comment_text")
    val commentText: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_at_i")
    val createdAtI: Int,
    @SerializedName("_highlightResult")
    val highlightResult: HighlightResult,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("objectID")
    val objectID: String,
    @SerializedName("parent_id")
    val parentId: Int,
    @SerializedName("points")
    val points: Int,
    @SerializedName("story_id")
    val storyId: Int,
    @SerializedName("story_text")
    val storyText: String,
    @SerializedName("story_title")
    val storyTitle: String,
    @SerializedName("story_url")
    val storyUrl: String,
    @SerializedName("_tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)