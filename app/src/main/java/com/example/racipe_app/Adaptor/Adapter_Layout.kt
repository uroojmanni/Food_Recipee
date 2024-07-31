package com.example.racipe_app.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.racipe_app.Model.Model_Food
import com.example.racipe_app.databinding.FoodLayoutBinding

class Adapter_Layout(
    private val dataList: List<Model_Food>,
    private val onItemClick: (Model_Food) -> Unit
) : RecyclerView.Adapter<Adapter_Layout.ViewHolder>() {

    inner class ViewHolder(private val binding: FoodLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model_Food) {
            binding.textView2.text = item.foodName
            binding.imageView4.setImageResource(item.image)
            binding.cardView.setOnClickListener {

                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataList.size
}
