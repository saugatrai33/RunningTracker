package com.saugatrai.runningtracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.saugatrai.runningtracker.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
}