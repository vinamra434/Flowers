package com.univ.flowers.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.univ.flowers.R
import com.univ.flowers.ui.base.BaseActivity
import com.univ.flowers.utils.ViewModelProviderFactory

class MainActivity() : BaseActivity<MainViewModel>() {


    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel()
            //this lambda creates and return SplashViewModel
        })[MainViewModel::class.java]
    }
}