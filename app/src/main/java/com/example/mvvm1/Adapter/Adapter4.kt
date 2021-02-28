package com.example.mvvm1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.models.Poster
import com.example.mvvm1.R
import com.example.mvvm1.TMDB
import com.example.mvvm1.databinding.HorImgBinding

//import com.example.mvvm1.Models.
class Adapter4(val context: Context, var list:ArrayList<Poster>):RecyclerView.Adapter<Adapter4.MyViewHolder>() {
    class MyViewHolder(var binding: HorImgBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=
            HorImgBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.poster=list[position]
    }

    override fun getItemCount(): Int=list.size


}