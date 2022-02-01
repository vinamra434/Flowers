package com.univ.flowers.ui.splash

import androidx.lifecycle.MutableLiveData
import com.univ.flowers.ui.base.BaseViewModel
import com.univ.flowers.utils.Event

class SplashViewModel() : BaseViewModel() {

    val launchHome: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate() {
        launchHome.postValue(Event(emptyMap()))
    }

}