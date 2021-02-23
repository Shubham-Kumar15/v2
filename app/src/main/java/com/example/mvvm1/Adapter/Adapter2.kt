package com.example.mvvm1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.Models.Series
import com.example.mvvm1.R
import com.example.mvvm1.TMDB

class Adapter2(val context: Context?, var list:ArrayList<Series>, val handler: ClickHandler):RecyclerView.Adapter<Adapter2.MyViewHolder>(){
    interface ClickHandler{
        fun Handle(id:Int)
    }
    class MyViewHolder(var view: View,val handler: ClickHandler): RecyclerView.ViewHolder(view){
        val imageView: ImageView =view.findViewById(R.id.imageView)
        val textViewM: TextView =view.findViewById(R.id.textViewMain)
        val textViewS: TextView =view.findViewById(R.id.textViewSumm)
        init {
            view.setOnClickListener(View.OnClickListener {
                handler.Handle(adapterPosition)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.row,parent,false)
        return MyViewHolder(view,handler)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewM.text=list.get(position).original_name
        holder.textViewS.text=list[position].overview
        val te:String= TMDB.baseImage+list.get(position).poster_path;
        Glide.with(context).load(te).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun ADD(l:List<Series>?){
        if(l==null)
            return
        var i:Int=0;
        while(i<l.size){
            list.add(l.get(i++))
            notifyItemInserted(list.size-1)
        }
    }
}