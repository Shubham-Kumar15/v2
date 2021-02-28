package com.example.tmdb.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm1.models.People
import com.example.mvvm1.databinding.CastRowBinding

class Adapter5(val context:Context, var list:ArrayList<People>) :RecyclerView.Adapter<Adapter5.MyViewModel>(){
    class MyViewModel(val binding:CastRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val rootView:CastRowBinding=
            CastRowBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewModel(rootView)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.binding.cast=list[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = list.size
}