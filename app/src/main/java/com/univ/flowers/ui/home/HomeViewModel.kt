package com.univ.flowers.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.example.Flowers
import com.google.gson.Gson
import com.univ.flowers.ui.base.BaseViewModel
import com.univ.flowers.utils.Constants
import com.univ.flowers.utils.Resource

class HomeViewModel(private var flowerList: Flowers) : BaseViewModel() {

    val flowers: MutableLiveData<Resource<Flowers>> = MutableLiveData()

    override fun onCreate() {

        flowerList = Gson().fromJson(Constants.dummyData, Flowers::class.java)

        flowers.postValue(Resource.success(flowerList))
    }


}