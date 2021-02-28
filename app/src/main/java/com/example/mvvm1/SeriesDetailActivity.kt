package com.example.mvvm1

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm1.Adapter.Adapter3
import com.example.mvvm1.models.episode
import com.example.mvvm1.viewmodel.SeriesDetailViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout

class SeriesDetailActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var collapsinToolbar: CollapsingToolbarLayout
    lateinit var imageView: ImageView
    lateinit var pd: ProgressDialog
    lateinit var adapter: Adapter3
    lateinit var recyclerView: RecyclerView
    lateinit var spinner: Spinner
    lateinit var viewModel:SeriesDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)
        initailize()

    }
    fun initailize(){
        viewModel=ViewModelProvider(this).get(SeriesDetailViewModel::class.java)
        pd= ProgressDialog(this)
        pd.setTitle("Loading")
        pd.setCancelable(false)
        pd.show()
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        if(viewModel.id==-1)
            viewModel.id=intent.getIntExtra(TMDB.ID,0)
        viewModel.loadSeries()
        imageView=findViewById(R.id.posterImageView)
        collapsinToolbar=findViewById(R.id.collapsinToolbarLayout)
//        volleyReqTV= VolleyReqTV(this, Request.Method.GET,TMDB.getSeriesDetail(id), Response.ErrorListener {
//            Toast.makeText(applicationContext,"Error aaya", Toast.LENGTH_LONG).show()
//        })
        spinner=findViewById(R.id.spinner1)
        recyclerView=findViewById(R.id.seasonDetailRecycler)
        recyclerView.layoutManager= LinearLayoutManager(this)
        adapter= Adapter3(this,ArrayList<episode>())
        recyclerView.adapter=adapter
        viewModel.series.observe(this, Observer {
            if (it != null) {
                Glide.with(this).load(TMDB.baseImage+it.poster_path).centerCrop().into(imageView)
            }
            if(pd.isShowing)
                pd.dismiss()
            Toast.makeText(this,"Hurrey",Toast.LENGTH_LONG)
            val li= it?.seasons?.size
            var te=1;
            val al:ArrayList<String>  = ArrayList<String>()
            while(te<= li!!){
                al.add("Season : "+te++)
            }
            val arrayAdapter=
                ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,al)
            spinner.adapter=arrayAdapter
            spinner.onItemSelectedListener=this
            loadSeriesDetail(viewModel.id,1)
        })
        viewModel.seasonList.observe(this, Observer {
            adapter.list=it as ArrayList<episode>
            adapter.notifyDataSetChanged()
        })
    }

    private fun loadSeriesDetail(id: Int, i: Int) {
        viewModel.loadSeason(i)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.loadSeason(position+1)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}