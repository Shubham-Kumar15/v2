package com.example.mvvm1.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.mvvm1.models.*

class MoviesDetailViewModel(val app:Application) : AndroidViewModel(app) , VolleyReqMovieImage.Callback ,
    VolleyReqMovieDetail.Callback,
    Response.ErrorListener, VolleyReqMovieCredit.Callback {
    //val rq: RequestQueue=Client.getRequestQueue(app.applicationContext)
    val repo:AppRepository=AppRepository(app.applicationContext)
    val md:MutableLiveData<MoviesDetail> = MutableLiveData<MoviesDetail>()
    val posters=MutableLiveData<List<Poster>>()
    val casts=MutableLiveData<List<People>>()
    val prodes=MutableLiveData<List<ProductionCOMPANY>>()
    var id:Int=-1
    var Castdroped=false
    var Productiodropped=false
    val loaded=false
    fun load(){
        if(loaded)
            return
        repo.getMovieCredit(id,this,this,app.applicationContext)
        repo.getMovieDetail(id,this,this,app.applicationContext)
        repo.getMovieImages(id,this,this,app.applicationContext)
    }
    override fun callback(re: MovieImageResponsee) {
        posters.value=re.posters
        //Log.e("Length of result",""+re.posters.size)

    }

    override fun callback(re: MoviesDetail) {
        md.value=re
        prodes.value=re.production_companies
    }

    override fun onErrorResponse(error: VolleyError?) {
        TODO("Not yet implemented")
    }

    override fun callback(re: CreditResult) {
        casts.value=re.cast
        Log.e("Cast updated"," "+re.cast.size)
    }

}