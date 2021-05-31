package com.example.testjusto.user.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testjusto.background.result.Result
import com.example.testjusto.user.background.repository.MainRepository
import kotlinx.coroutines.launch

class MainSharedViewModel(val mainRepository: MainRepository): ViewModel() {

    companion object {
        private val TAG = MainSharedViewModel::class.java.simpleName
    }

    fun getRandomUser() {

        viewModelScope.launch {
            mainRepository.getRandomUSer().apply {
                when(this) {
                    is Result.Request -> {
                        Log.e(TAG, "getRandomUser: onRequest")
                    }
                    is Result.Success -> {
                        Log.e(TAG, "getRandomUser: onSuccess")
                    }
                    is Result.Error -> {
                        Log.e(TAG, "getRandomUser: onError")
                    }
                }
            }
        }
    }
}