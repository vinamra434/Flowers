package com.univ.flowers.data.model

import com.google.gson.annotations.SerializedName


data class Flower(

    @SerializedName("category") var category: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("instructions") var instructions: String? = null,
    @SerializedName("photo") var photo: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("productId") var productId: Int? = null

)

