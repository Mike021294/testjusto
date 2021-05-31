package com.example.testjusto.user.background.pojo


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    var name: String?,
    @SerializedName("value")
    var value: Any?
)