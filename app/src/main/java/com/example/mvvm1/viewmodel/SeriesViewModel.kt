package com.example.mvvm1.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.mvvm1.models.*

class SeriesViewModel(val app:Application) : AndroidViewModel(app),
    Response.ErrorListener, VolleyReqSeriesList.Callback {
    val list: MutableLiveData<List<Series>> = MutableLiveData<List<Series>>()
    val repo: AppRepository = AppRepository(app.applicationContext)
    init {
        repo.getSeriesList(1,this,this)
    }

    override fun onErrorResponse(error: VolleyError?) {
        Log.e("Log","Response is error")
    }

    override fun callback(sr: Series_Result) {
        list.value=sr.results
    }


}