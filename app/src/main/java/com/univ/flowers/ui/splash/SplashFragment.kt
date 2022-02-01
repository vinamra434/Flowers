package com.univ.flowers.ui.splash

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.univ.flowers.R
import com.univ.flowers.ui.base.BaseFragment
import com.univ.flowers.utils.Event
import com.univ.flowers.utils.Logger
import com.univ.flowers.utils.ViewModelProviderFactory

class SplashFragment : BaseFragment<SplashViewModel>() {

    private val NAME = "SplashFragment"

    override fun provideLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun setupView(view: View) {
        Logger.d(NAME, "setupView")
        viewModel.launchHome.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {

                val navHostFragment =
                    activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController

                Handler(Looper.getMainLooper()).postDelayed({
                    navController.navigate(R.id.action_splashFragment_to_homeFragment)
                }, 1200)
            }
        })
    }

    override fun setupViewModel() {

        viewModel = ViewModelProvider(this, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel()
            //this lambda creates and return SplashViewModel
        })[SplashViewModel::class.java]

    }
}
