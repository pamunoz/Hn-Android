package com.example.hnandroid.di.modules

import android.app.Application
import com.example.hnandroid.db.HnStoriesDatabase
import com.example.hnandroid.db.HnStoriesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HnStoriesDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): HnStoriesDatabase = HnStoriesDatabase.buildDefault(app)

    @Singleton
    @Provides
    fun provideHnStoryDao(db: HnStoriesDatabase): HnStoriesDao = db.hnStoryDao()

}