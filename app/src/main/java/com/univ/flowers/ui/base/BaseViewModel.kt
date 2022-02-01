package com.univ.flowers.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.univ.flowers.utils.Resource

abstract class BaseViewModel() : ViewModel() {

    //for showing messages to screens
    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    abstract fun onCreate()
}