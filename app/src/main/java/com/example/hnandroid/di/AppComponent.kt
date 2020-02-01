package com.example.hnandroid.di

import android.app.Application
import com.example.hnandroid.HnAndroidApp
import com.example.hnandroid.di.modules.ActivityModule
import com.example.hnandroid.di.modules.HnServiceModule
import com.example.hnandroid.di.modules.HnStoriesDatabaseModule
import com.example.hnandroid.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    // Dagger Support
    AndroidInjectionModule::class,
    // App
    HnStoriesDatabaseModule::class,
    HnServiceModule::class,
    ActivityModule::class,
    ViewModelModule::class
    ])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(hnAndroidApp: HnAndroidApp)
}