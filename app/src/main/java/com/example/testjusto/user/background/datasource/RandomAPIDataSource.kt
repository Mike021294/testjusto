package com.example.testjusto.user.background.datasource

import com.example.testjusto.background.base.BaseDataSource
import com.example.testjusto.background.web_service.WebService

class RandomAPIDataSource: BaseDataSource() {

    suspend fun getUser() = requestWS { WebService.services().getRandomUser() }
}