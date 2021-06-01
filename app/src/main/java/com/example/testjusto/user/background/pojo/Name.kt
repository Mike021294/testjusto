package com.example.testjusto.user.background.pojo


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("title")
    var title: String?,
    @SerializedName("first")
    var first: String?,
    @SerializedName("last")
    var last: String?
    ) {
    override fun toString(): String {
        return "$title $first $last"
    }
}