package com.example.mvvm1.FRAGMENTS

import android.app.ProgressDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.example.mvvm1.Adapter.Adapter2
import com.example.mvvm1.Models.Series
import com.example.mvvm1.R
import com.example.mvvm1.SeriesDetailActivity
import com.example.mvvm1.TMDB
import com.example.mvvm1.ViewModel.SeriesViewModel

class SeriesFragment : Fragment(), Adapter2.ClickHandler {

    lateinit var pd: ProgressDialog
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter2
    lateinit var layoutManager: LinearLayoutManager
    lateinit var rq: RequestQueue
    var page=1


    companion object {
        fun newInstance() = SeriesFragment()
    }

    private lateinit var viewModel: SeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
       val view= inflater.inflate(R.layout.series_fragment, container, false)
        recyclerView=view.findViewById(R.id.seriesRecycler)
        adapter= Adapter2(context,ArrayList<Series>(),this)
        layoutManager= LinearLayoutManager(context)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SeriesViewModel::class.java)
        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.list=it as ArrayList<Series>
            adapter.notifyDataSetChanged()
        })
    }

    override fun Handle(id: Int) {
        val intent=Intent(context,SeriesDetailActivity::class.java)
        intent.putExtra(TMDB.ID,adapter.list[id].id)
        startActivity(intent)
    }

}