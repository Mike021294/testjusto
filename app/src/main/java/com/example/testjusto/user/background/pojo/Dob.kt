package com.example.testjusto.user.background.pojo


import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    var date: String?,
    @SerializedName("age")
    var age: Int?
)