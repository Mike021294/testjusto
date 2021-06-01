package com.example.testjusto.background.base


import android.util.Log
import com.example.testjusto.background.result.Result
import retrofit2.Response

abstract class BaseDataSource {

    companion object {
        private val TAG = BaseDataSource::class.java.simpleName
    }

    protected suspend fun <T> requestWS(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Log.d(TAG, "error: $message")
        return Result.error("Call failure: $message")
    }
}