package com.example.hnandroid.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hnandroid.model.HnStories

@Database(
    entities = [HnStories::class],
    version = HnStoriesDatabaseMigration.latestVersion
)
abstract class HnStoriesDatabase : RoomDatabase() {
    /**
     * Get news story DAO
     */
    abstract fun hnStoryDao(): HnStoriesDao

    companion object {
        private const val databaseName = "hnstories-db"

        fun buildDefault(context: Context) =
            Room.databaseBuilder(context, HnStoriesDatabase::class.java, databaseName)
                .addMigrations(*HnStoriesDatabaseMigration.allMigrations)
                .build()

        @VisibleForTesting
        fun buildTest(context: Context) =
            Room.inMemoryDatabaseBuilder(context, HnStoriesDatabase::class.java)
                .build()
    }
}