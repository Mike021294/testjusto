package com.example.testjusto.background.web_service

import com.example.testjusto.user.background.response.GetUserResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface WebServicesDefinition {

    @GET("/api/")
    fun getRandomUser(): Call<GetUserResponse>
}