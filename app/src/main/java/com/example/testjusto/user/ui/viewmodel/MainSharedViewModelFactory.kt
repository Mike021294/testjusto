package com.example.testjusto.user.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testjusto.user.background.datasource.RandomAPIDataSource
import com.example.testjusto.user.background.repository.MainRepository

@Suppress("UNCHECKED_CAST")
class MainSharedViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainSharedViewModel::class.java)) {
            return MainSharedViewModel(mainRepository = MainRepository(randomAPIDataSource = RandomAPIDataSource())) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}