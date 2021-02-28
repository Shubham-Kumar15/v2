package com.example.mvvm1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.mvvm1.models.AppRepository
import com.example.mvvm1.models.Movies
import com.example.mvvm1.models.Result
import com.example.mvvm1.models.VolleyReqMovieList

class MoviesViewModel(val app:Application) : AndroidViewModel(app), Response.ErrorListener, VolleyReqMovieList.Callback {
    // TODO: Implement the ViewModel
    val list:MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    val repo:AppRepository=AppRepository(app.applicationContext)
    init {
        repo.getMovieList(1,this,this,app.applicationContext)
    }
    override fun onErrorResponse(error: VolleyError?) {

    }

    override fun callback(res: Result) {
        list.value=res.results
    }


}