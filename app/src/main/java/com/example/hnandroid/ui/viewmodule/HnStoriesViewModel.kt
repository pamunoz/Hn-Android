package com.example.hnandroid.ui.viewmodule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.hnandroid.model.HnStories
import com.example.hnandroid.model.ViewState
import com.example.hnandroid.repo.HnRepository
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject


/**
 * A container for [HnStoies] related data to show on the UI.
 */
class HnStoriesViewModel @Inject constructor(
    val hnRepository: HnRepository
) : ViewModel() {


    @ExperimentalCoroutinesApi
    private val hnStories: LiveData<ViewState<MutableList<HnStories>>> = hnRepository.getHnStories().asLiveData()

    /**
     * Return stories to observeNotNull on the UI.
     */
    @ExperimentalCoroutinesApi
    fun getHnStories(): LiveData<ViewState<MutableList<HnStories>>> = hnStories

    fun deleteStory(story: HnStories){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    hnRepository.delete(story)
                }
            } catch (e: Exception) {
                Log.e("ViewModelError", e.message!!)
            }

        }

    }
}