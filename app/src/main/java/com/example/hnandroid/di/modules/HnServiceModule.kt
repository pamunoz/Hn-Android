package com.example.hnandroid.di.modules

import com.example.hnandroid.api.HnService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
class HnServiceModule {

    @Singleton
    @Provides
    fun provideHnService(): HnService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HnService::class.java)
    }

    companion object {
        private const val BASE_URL = "http://hn.algolia.com/api/v1/"
    }
}