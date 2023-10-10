package com.diablos.schoolnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diablos.schoolnews.databinding.ItemRewDataBinding
import com.squareup.picasso.Picasso

class DataAdapter (private val mList : ArrayList<DataFirebase>):
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: ItemRewDataBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind (data:DataFirebase) {
            binding.textView.text = data.dataText
            binding.textView2.text = data.soattext
            Picasso.get().load(data.imageuri).into(binding.imageView2)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRewDataBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )
    }
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenTitem = mList[position]
        holder.bind(currenTitem)

    }


}