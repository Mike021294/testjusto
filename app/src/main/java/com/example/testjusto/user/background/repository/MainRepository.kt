package com.example.testjusto.user.background.repository

import com.example.testjusto.background.result.Result
import com.example.testjusto.user.background.datasource.RandomAPIDataSource
import com.example.testjusto.user.background.response.GetUserResponse

class MainRepository(val randomAPIDataSource: RandomAPIDataSource) {

    fun getRandomUSer(): Result<GetUserResponse> {
        return randomAPIDataSource.getUser()
    }
}