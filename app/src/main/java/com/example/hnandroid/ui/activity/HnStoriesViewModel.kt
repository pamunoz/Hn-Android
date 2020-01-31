package com.example.hnandroid.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.model.ViewState
import com.example.hnandroid.repo.HnRepository
import javax.inject.Inject


/**
 * A container for [HnStoies] related data to show on the UI.
 */
class HnStoriesViewModel @Inject constructor(
    hnRepository: HnRepository
) : ViewModel() {
    private val hnStories: LiveData<ViewState<List<HnStories>>> = hnRepository.getHnStories().asLiveData()

    /**
     * Return stories to observeNotNull on the UI.
     */
    fun getHnStories(): LiveData<ViewState<List<HnStories>>> = hnStories
}