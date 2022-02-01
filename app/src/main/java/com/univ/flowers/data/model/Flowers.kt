package com.example.example

import com.google.gson.annotations.SerializedName
import com.univ.flowers.data.model.Flower


data class Flowers(

    @SerializedName("flowerlist") var flowerlist: ArrayList<Flower> = arrayListOf()

)