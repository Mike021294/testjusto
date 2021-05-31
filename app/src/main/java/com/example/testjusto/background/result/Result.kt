package com.example.testjusto.background.result

sealed class Result<out T : Any> {

    data class Request(val any: Nothing?) : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Request -> "Request[any=$any]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=${exception.message}]"
        }
    }
}
