package com.example.mvvm1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.mvvm1.Models.*

class SeriesDetailViewModel(val app:Application) : AndroidViewModel(app), Response.ErrorListener,
    VolleyReqTV.Callback, VolleyReqSeries.Callback {
    var id:Int=-1
    val series:MutableLiveData<TV_Response> = MutableLiveData<TV_Response>()
    val seasonList:MutableLiveData<List<episode>> = MutableLiveData<List<episode>>()
    val repo:AppRepository = AppRepository(app.applicationContext)
    fun loadSeries() {
        repo.getSeriesDetail(id,this,this)
    }
    fun loadSeason(season: Int){
        repo.getSeasonList(id,season,this,this)
    }

    override fun onErrorResponse(error: VolleyError?) {
        TODO("Not yet implemented")
    }

    override fun cllback(tv: TV_Response?) {
        series.value=tv
        loadSeason(1)
    }

    override fun callback(sr: SeasonResponse) {
        seasonList.value=sr.episodes
    }
}