package com.example.hnandroid.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hnandroid.di.base.ViewModelFactory
import com.example.hnandroid.di.base.ViewModelKey
import com.example.hnandroid.ui.viewmodule.HnStoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Describes all the [ViewModel] which need to be
 * created using DI.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HnStoriesViewModel::class)
    abstract fun bindHnStoriesViewModel(hnStoriesViewModel: HnStoriesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}