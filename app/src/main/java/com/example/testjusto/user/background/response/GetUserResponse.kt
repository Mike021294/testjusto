package com.example.testjusto.user.background.response


import com.example.testjusto.user.background.pojo.Info
import com.example.testjusto.user.background.pojo.Result
import com.google.gson.annotations.SerializedName

data class GetUserResponse(

    @SerializedName("results")
    var results: ArrayList<Result>?,
    @SerializedName("info")
    var info: Info?
)