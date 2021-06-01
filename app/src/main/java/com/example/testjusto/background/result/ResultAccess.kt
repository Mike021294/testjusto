package com.example.testjusto.background.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T> performGetOperation(networkCall: suspend () -> Result<T>): LiveData<Result<T>> =

    liveData(Dispatchers.IO) {
        emit(Result.loading())

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Result.Status.SUCCESS) {
            emit(Result.success(responseStatus.data!!))
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error(responseStatus.message!!))
        }
    }