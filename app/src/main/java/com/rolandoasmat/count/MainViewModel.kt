package com.rolandoasmat.count

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class MainViewModel(private val countsRepository: CountsRepository): ViewModel() {

    private val currentCount: Int
        get() { return  count.value ?: 0 }

    val count: LiveData<Int> = countsRepository.count.asLiveData()

    fun incrementButtonPressed() = countsRepository.updateCount(currentCount + 1)

    fun decrementButtonPressed() = countsRepository.updateCount(currentCount - 1)

    fun resetButtonPressed() = countsRepository.updateCount(0)
}