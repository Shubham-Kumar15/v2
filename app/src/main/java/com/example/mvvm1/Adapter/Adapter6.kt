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
import com.example.mvvm1.Models.ProductionCOMPANY
import com.example.mvvm1.R
import com.example.mvvm1.TMDB
class Adapter6(val context:Context, var list:List<ProductionCOMPANY>) :RecyclerView.Adapter<Adapter6.MyViewModel>(){
    class MyViewModel(val view: View):RecyclerView.ViewHolder(view){
        val castImage:ImageView=view.findViewById(R.id.mainImageView)
        val castName:TextView=view.findViewById(R.id.mainTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val view:View=LayoutInflater.from(context).inflate(R.layout.company_row,parent,false)

        return MyViewModel(view)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val p:ProductionCOMPANY=list[position]
        holder.castName.text=p.name
        val a:String= TMDB.baseImage+p.logo_path
        Log.e("Production Image",a)
        Glide.with(context).load(a).into(holder.castImage)
    }

    override fun getItemCount(): Int = list.size
}