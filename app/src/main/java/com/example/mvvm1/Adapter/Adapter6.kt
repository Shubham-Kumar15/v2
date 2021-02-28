package com.example.tmdb.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.models.ProductionCOMPANY
import com.example.mvvm1.R
import com.example.mvvm1.TMDB
import com.example.mvvm1.databinding.CompanyRowBinding

class Adapter6(val context:Context, var list:List<ProductionCOMPANY>) :RecyclerView.Adapter<Adapter6.MyViewModel>(){
    class MyViewModel(val binding: CompanyRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val binding:CompanyRowBinding=
            CompanyRowBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewModel(binding)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val p:ProductionCOMPANY=list[position]
        holder.binding.production=p
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = list.size
}