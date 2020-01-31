package com.example.hnandroid.di

import android.app.Application
import com.example.hnandroid.HnAndroidApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
// TODO: Add the Modules
@Singleton
@Component(modules = [
    // Dagger Support
    AndroidInjectionModule::class
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