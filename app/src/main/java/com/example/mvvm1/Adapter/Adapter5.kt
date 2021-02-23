package com.example.tmdb.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.Models.People
import com.example.mvvm1.R
import com.example.mvvm1.TMDB
class Adapter5(val context:Context, var list:ArrayList<People>) :RecyclerView.Adapter<Adapter5.MyViewModel>(){
    class MyViewModel(val view: View):RecyclerView.ViewHolder(view){
        val castImage:ImageView=view.findViewById(R.id.mainImageView)
        val castName:TextView=view.findViewById(R.id.mainTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val view:View=LayoutInflater.from(context).inflate(R.layout.cast_row,parent,false)

        return MyViewModel(view)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val p:People=list[position]
        holder.castName.text=p.name
        val a:String= TMDB.baseImage+p.profile_path
        Glide.with(context).load(a).into(holder.castImage)
    }

    override fun getItemCount(): Int = list.size
}