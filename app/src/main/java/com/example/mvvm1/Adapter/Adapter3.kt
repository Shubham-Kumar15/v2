package com.example.mvvm1.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.Models.episode
import com.example.mvvm1.R
import com.example.mvvm1.TMDB

class Adapter3(val context: Context, var list:ArrayList<episode>):RecyclerView.Adapter<Adapter3.MyViewholder>() {
    class MyViewholder(val view: View):RecyclerView.ViewHolder(view){
        val imageView: ImageView =view.findViewById(R.id.imageView)
        val textViewM: TextView =view.findViewById(R.id.textViewMain)
        val textViewS: TextView =view.findViewById(R.id.textViewSumm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater:LayoutInflater=LayoutInflater.from(parent.context)
        val v:View=inflater.inflate(R.layout.row,parent,false)
        return MyViewholder(v)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        val e:episode=list[position]
        val a= TMDB.baseImage+e.still_path
        Log.e("image url",a)
        Glide.with(context).load(a).into(holder.imageView)
        holder.textViewM.text=e.name
        holder.textViewS.text=e.overview
    }

    override fun getItemCount(): Int=list.size

    fun ADD(l:ArrayList<episode>){
        for(i in l){
            list.add(i)
            //notifyItemInserted(list.size-1)
        }
        notifyDataSetChanged()
    }

    fun RESET(l:ArrayList<episode>){
        list.clear()
        ADD(l)
    }
}