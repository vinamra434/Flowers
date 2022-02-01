package com.univ.flowers.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.univ.flowers.utils.Logger
import com.univ.flowers.utils.Toaster

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.d("BaseFragment", "onCreate")
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupObservers()
        viewModel.onCreate()
    }

    abstract fun setupViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Logger.d("baseFrag", "onCreateView")
        return inflater.inflate(provideLayoutId(), container, false)
    }


    protected open fun setupObservers() {
        Logger.d("baseFrag", "setupObservers")
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Logger.d("baseFrag", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }


    fun showMessage(message: String) = context?.let { Toaster.show(it, message) }

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))


    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setupView(view: View)

}