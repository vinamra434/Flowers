package com.univ.flowers.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.example.Flowers
import com.univ.flowers.R
import com.univ.flowers.data.model.Flower
import com.univ.flowers.databinding.FragmentHomeBinding
import com.univ.flowers.ui.base.BaseFragment
import com.univ.flowers.ui.home.flowers.FlowersListAdapter
import com.univ.flowers.utils.Logger
import com.univ.flowers.utils.Toaster
import com.univ.flowers.utils.ViewModelProviderFactory

class HomeFragment : BaseFragment<HomeViewModel>(), onFlowerItemClick {

    private val NAME = "HomeFragment"


    companion object {

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var flowersListAdapter: FlowersListAdapter

    override fun provideLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setupView(view: View) {
        Logger.d(NAME, "setupView")
        binding = FragmentHomeBinding.bind(view)

        flowersListAdapter = FlowersListAdapter(requireContext(), Flowers(), this)
        binding.rvHome.adapter = flowersListAdapter

    }

    override fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(Flowers())
        })[HomeViewModel::class.java]
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.flowers.observe(this, Observer {
            it.data?.run {
                Logger.d(NAME, "flower list received in fragment")
                flowersListAdapter.updateList(flowerlist)
            }
        })
    }

    override fun onItemClick(flower: Flower) {
        Logger.d(NAME, "onItemClick flower = $flower")
        Toaster.show(requireContext(), "You clicked on ${flower.name}")
    }
}


interface onFlowerItemClick {
    fun onItemClick(flower: Flower)
}