package com.univ.flowers.ui.home.flowers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Flowers
import com.univ.flowers.data.model.Flower
import com.univ.flowers.databinding.ItemFlowerBinding
import com.univ.flowers.ui.home.onFlowerItemClick
import com.univ.flowers.utils.Logger

class FlowersListAdapter(
    private val context: Context,
    private var items: Flowers,
    private val listener: onFlowerItemClick
) :
    RecyclerView.Adapter<FlowersListAdapter.FlowerItemViewHolder>() {

    private val NAME = "FlowersListAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerItemViewHolder {
        Logger.d(NAME, "onCreateViewHolder")
        val binding = ItemFlowerBinding.inflate(LayoutInflater.from(context), parent, false)
        return FlowerItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: FlowerItemViewHolder, position: Int) {
        Logger.d(NAME, "onBindViewHolder")

        with(viewHolder) {
            with(items.flowerlist[position]) {
                binding.tvItemHomeName.text = name
                binding.tvItemHomeDesc.text = instructions
                binding.cvItemHome.setOnClickListener { listener.onItemClick(this) }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.flowerlist.size
    }

    fun updateList(newList: ArrayList<Flower>) {
        Logger.d(NAME, "updateList")
        items.flowerlist.clear()
        items.flowerlist.addAll(newList)
        notifyDataSetChanged()
    }


    class FlowerItemViewHolder(var binding: ItemFlowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}