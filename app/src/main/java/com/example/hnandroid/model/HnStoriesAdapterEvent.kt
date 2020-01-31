package com.example.hnandroid.model

/**
 * Describes all the events originated from
 * [HnStoriesAdapter].
 */
sealed class HnStoriesAdapterEvent {
    /* Describes item click event  */
    object ClickEvent : HnStoriesAdapterEvent()
}