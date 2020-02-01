package com.example.hnandroid

import android.app.Application
import com.example.hnandroid.di.base.AppInjector
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HnAndroidApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        // Add di
        AppInjector.init(this)
        AndroidThreeTen.init(this)
    }
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}