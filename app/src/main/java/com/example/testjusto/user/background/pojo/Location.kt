package com.example.testjusto.user.background.pojo


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    var street: Street?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("state")
    var state: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("postcode")
    var postcode: Int?,
    @SerializedName("coordinates")
    var coordinates: Coordinates?,
    @SerializedName("timezone")
    var timezone: Timezone?
)