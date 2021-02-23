package com.example.mvvm1.Models

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.example.mvvm1.Adapter.Adapter1
import com.example.mvvm1.TMDB

class AppRepository (context: Context) {
    val rq=Client.getRequestQueue(context)
    fun getMovieList(page:Int,callback:VolleyReqMovieList.Callback,error:Response.ErrorListener,context:Context){
        val req =
            VolleyReqMovieList(callback, Request.Method.GET, TMDB.getAPI(page),error)
        rq.add(req)
    }
    fun getMovieDetail(id:Int,callback:VolleyReqMovieDetail.Callback,error: Response.ErrorListener,context: Context){
        val req= VolleyReqMovieDetail(callback,Request.Method.GET,TMDB.getMoviesAPI(id),error)
        rq.add(req)
    }
    fun getMovieCredit(id:Int,callback:VolleyReqMovieCredit.Callback,error: Response.ErrorListener,context: Context){

        val req= VolleyReqMovieCredit(callback,Request.Method.GET,TMDB.getMoviesCredit(id),error)
        rq.add(req)
    }
    fun getMovieImages(id:Int,callback:VolleyReqMovieImage.Callback,error: Response.ErrorListener,context: Context){

        val req= VolleyReqMovieImage(callback, Request.Method.GET,TMDB.getMovieImageList(id),error)
        rq.add(req)
    }

    fun getSeriesList(page:Int,callback:VolleyReqSeriesList.Callback,error: Response.ErrorListener){
        val req=VolleyReqSeriesList(callback,Request.Method.GET,TMDB.getSeriesApi(page),error)
        rq.add(req)
    }

    fun getSeriesDetail(id:Int,callback:VolleyReqTV.Callback , error: Response.ErrorListener){
        val req=VolleyReqTV(callback, Request.Method.GET,TMDB.getSeriesDetail(id),error)
        rq.add(req)
    }
    fun getSeasonList(id:Int,ses:Int,callback:VolleyReqSeries.Callback,error: Response.ErrorListener){
        val req:VolleyReqSeries= VolleyReqSeries(callback,Request.Method.GET,TMDB.getSeriesAPI(id,ses),error)
        rq.add(req)
    }
}