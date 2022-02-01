package com.univ.flowers.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.univ.flowers.utils.Logger
import com.univ.flowers.utils.Toaster

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        if (savedInstanceState == null) viewModel.onCreate() else Logger.d(
            "activity",
            "device rotated"
        )
    }


    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    protected abstract fun setupViewModel()

    protected abstract fun setupView(savedInstanceState: Bundle?)

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    @LayoutRes
    protected abstract fun provideLayoutId(): Int
}