package com.example.hnandroid.repo

import com.example.hnandroid.api.HnService
import com.example.hnandroid.db.HnStoriesDao
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.model.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline.
 */
@Singleton
class HnRepository @Inject constructor(
    private val hnStoryDao: HnStoriesDao,
    private val hnService: HnService
) {
    /**
     * Fetch the stories from database if exist else fetch from web
     * and persist them in the database
     */
    @ExperimentalCoroutinesApi
    fun getHnStories(): Flow<ViewState<List<HnStories>>> {
        return flow {
            // 1. Start with loading + data from database
            emit(ViewState.loading())
            emit(ViewState.success(hnStoryDao.getStories()))

            // 2. Try fetching new stories -> save + emit
            val storiesSource = hnService.getStories()
            hnStoryDao.insertStories(storiesSource.stories)

            // 3. Get stories from database [Single source of truth]
            emit(ViewState.success(hnStoryDao.getStories()))
        }.catch {
            emit(ViewState.error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun delete(story: HnStories) {
        hnStoryDao.delete(story)
    }
}