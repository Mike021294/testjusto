package com.example.testjusto.user.background.datasource

import com.example.testjusto.background.result.Result
import com.example.testjusto.background.web_service.WebService
import com.example.testjusto.user.background.response.GetUserResponse
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class RandomAPIDataSource {

    fun getUser(): Result<GetUserResponse> {

        var result: Result<GetUserResponse>?

        val call = WebService.services().getRandomUser()

        result = Result.Request(any = null)

        call.enqueue(object: Callback<GetUserResponse> {
            override fun onResponse(call: Call<GetUserResponse>, response: Response<GetUserResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val responseBody: GetUserResponse = response.body()!!

                        result = Result.Success(data = responseBody)
                    } else {
                        onFailure(call, Throwable("Body response empty"))
                    }
                } else {
                    onFailure(call, Throwable(response.message()))
                }
            }

            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                result = Result.Error(IOException(t.message))
            }
        })

        return result as Result<GetUserResponse>
    }
}