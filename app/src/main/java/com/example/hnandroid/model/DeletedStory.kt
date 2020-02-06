package com.example.hnandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DeletedStory(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?)