package com.example.hnandroid.db

import androidx.room.migration.Migration


/**
 * Describes migration related to [HnStoriesDatabase].
 */
internal object HnStoriesDatabaseMigration {
    // change the schema
    const val latestVersion = 1

    val allMigrations: Array<Migration>
        get() = arrayOf(
            //// Add migrations here
            // migration_1_2()
        )
    ///**
    // * + describe
    // * + the
    // * + migration
    // * + steps
    // */
    // fun migration_1_2() = object : Migration(1, 2) {
    //    override fun migrate(database: SupportSQLiteDatabase) {
    //        // Add migration code/SQL here, referencing [V1] and [V2] constants
    //    }
    // }
    object V1 {
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
}