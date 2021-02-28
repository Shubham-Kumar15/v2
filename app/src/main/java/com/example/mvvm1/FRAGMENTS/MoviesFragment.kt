package com.example.mvvm1.FRAGMENTS

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
import com.example.mvvm1.Adapter.Adapter1
import com.example.mvvm1.models.Movies
import com.example.mvvm1.MoviesDetailActivity
import com.example.mvvm1.R
import com.example.mvvm1.TMDB
import com.example.mvvm1.viewmodel.MoviesViewModel

class MoviesFragment : Fragment(), Adapter1.ClickHandler {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter:Adapter1
    lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.movies_fragment, container, false)
        recyclerView=view.findViewById(R.id.moviesRecycler)
        adapter= Adapter1(context, ArrayList<Movies>(),this)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        val obs:Observer<List<Movies>> = Observer {
            adapter.list= it as java.util.ArrayList<Movies>
            adapter.notifyDataSetChanged()
        }
        viewModel.list.observe(viewLifecycleOwner,obs)
    }

    override fun Handle(id: Int) {
        val intent:Intent= Intent(context,MoviesDetailActivity::class.java)
        intent.putExtra(TMDB.ID,adapter.list[id].id)
        startActivity(intent)

    }

}