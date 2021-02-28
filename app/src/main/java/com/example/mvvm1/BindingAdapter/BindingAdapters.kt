package com.example.mvvm1.BindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mvvm1.TMDB

@BindingAdapter("imageURL")
fun setImageFromUrl(view:ImageView, url:String?){
    if(url==null)
        return
    val a:String = TMDB.baseImage+url
    Glide.with(view.context).load(a).into(view)
}