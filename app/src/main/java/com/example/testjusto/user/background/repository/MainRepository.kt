package com.example.testjusto.user.background.repository

import com.example.testjusto.background.result.performGetOperation
import com.example.testjusto.user.background.datasource.RandomAPIDataSource

class MainRepository(private val randomAPIDataSource: RandomAPIDataSource) {

    fun getRandomUser() = performGetOperation(networkCall = { randomAPIDataSource.getUser() })
}