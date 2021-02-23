package com.example.mvvm1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.mvvm1.Models.*

class SeriesViewModel(val app:Application) : AndroidViewModel(app),
    Response.ErrorListener, VolleyReqSeriesList.Callback {
    val list: MutableLiveData<List<Series>> = MutableLiveData<List<Series>>()
    val repo: AppRepository = AppRepository(app.applicationContext)
    init {
        repo.getSeriesList(1,this,this)
    }

    override fun onErrorResponse(error: VolleyError?) {
        TODO("Not yet implemented")
    }

    override fun callback(sr: Series_Result) {
        list.value=sr.results
    }


}