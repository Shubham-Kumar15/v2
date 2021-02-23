package com.example.mvvm1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.Models.Poster
import com.example.mvvm1.R
import com.example.mvvm1.TMDB

//import com.example.mvvm1.Models.
class Adapter4(val context: Context, var list:ArrayList<Poster>):RecyclerView.Adapter<Adapter4.MyViewHolder>() {
    class MyViewHolder(var view:View):RecyclerView.ViewHolder(view){
        val imageView:ImageView=view.findViewById(R.id.horImgView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.hor_img,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val p:Poster=list.get(position)
        val a:String= TMDB.baseImage+p.file_path
        Glide.with(context).load(a).centerCrop().into(holder.imageView)
    }

    override fun getItemCount(): Int=list.size


}