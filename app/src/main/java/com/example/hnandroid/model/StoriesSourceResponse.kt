package com.example.hnandroid.model


import com.google.gson.annotations.SerializedName

data class StoriesSourceResponse(
    @SerializedName("exhaustiveNbHits")
    val exhaustiveNbHits: Boolean,
    @SerializedName("hits")
    val hits: List<Story>,
    @SerializedName("hitsPerPage")
    val hitsPerPage: Int,
    @SerializedName("nbHits")
    val nbHits: Int,
    @SerializedName("nbPages")
    val nbPages: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("params")
    val params: String,
    @SerializedName("processingTimeMS")
    val processingTimeMS: Int,
    @SerializedName("query")
    val query: String
)

data class Author(
    @SerializedName("matchLevel")
    val matchLevel: String,
    @SerializedName("matchedWords")
    val matchedWords: List<Any>,
    @SerializedName("value")
    val value: String
)

data class HighlightResult(
    @SerializedName("author")
    val author: Author,
    @SerializedName("title")
    val title: Title,
    @SerializedName("url")
    val url: Url
)

data class Title(
    @SerializedName("fullyHighlighted")
    val fullyHighlighted: Boolean,
    @SerializedName("matchLevel")
    val matchLevel: String,
    @SerializedName("matchedWords")
    val matchedWords: List<String>,
    @SerializedName("value")
    val value: String
)

data class Url(
    @SerializedName("matchLevel")
    val matchLevel: String,
    @SerializedName("matchedWords")
    val matchedWords: List<Any>,
    @SerializedName("value")
    val value: String
)