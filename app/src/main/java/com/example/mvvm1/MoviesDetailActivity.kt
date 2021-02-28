package com.example.mvvm1

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm1.Adapter.Adapter4
import com.example.mvvm1.models.MoviesDetail
import com.example.mvvm1.models.People
import com.example.mvvm1.models.Poster
import com.example.mvvm1.models.ProductionCOMPANY
import com.example.mvvm1.viewmodel.MoviesDetailViewModel
import com.example.mvvm1.databinding.ActivityMoviesDetailBinding
import com.example.tmdb.Adapter.Adapter5
import com.example.tmdb.Adapter.Adapter6

class MoviesDetailActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var posterRecyclerView: RecyclerView
    lateinit var adapter: Adapter4
    lateinit var adapter5: Adapter5
    lateinit var adapter6: Adapter6
    lateinit var pd: ProgressDialog
    lateinit var title: TextView
    lateinit var tagline: TextView
    lateinit var budget: TextView
    lateinit var revenue: TextView
    lateinit var overview: TextView
    lateinit var castDrpdown: ImageButton
    lateinit var castRecyclerView: RecyclerView
    lateinit var geners: TextView
    lateinit var posterList:ArrayList<Poster>
    lateinit var castList:ArrayList<People>
    lateinit var prodctionList:ArrayList<ProductionCOMPANY>
    lateinit var productionDropdown: ImageButton
    lateinit var productionRecyclerView: RecyclerView
    lateinit var viewModel:MoviesDetailViewModel
    var md: MoviesDetail?=null
    lateinit var binding:ActivityMoviesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_movies_detail)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movies_detail)
        viewModel= ViewModelProvider(this).get(MoviesDetailViewModel::class.java)
        binding.viewModel=viewModel
        initilize()
        viewModel.load()
    }

    fun initilize(){
        //viewModel= ViewModelProvider(this).get(MoviesDetailViewModel::class.java)
        if(viewModel.posters.value==null) posterList= ArrayList<Poster>()
        else posterList=viewModel.posters.value as ArrayList<Poster>
        if(viewModel.casts.value!=null) castList=viewModel.casts.value as ArrayList<People>
        else castList= ArrayList<People>()
        if(viewModel.prodes.value!=null) prodctionList=viewModel.prodes.value as ArrayList<ProductionCOMPANY>
        else prodctionList=ArrayList<ProductionCOMPANY>()
        productionDropdown=findViewById(R.id.imageButtonProductionsDropdown)
        pd= ProgressDialog(this)
        pd.setTitle("Loading")
        pd.setCancelable(false)
        pd.show()
        if(viewModel.id==-1){
            viewModel.id=intent.getIntExtra(TMDB.ID,0)
        }
        Log.e("The movie Id received from main activity",""+viewModel.id)
        title=findViewById(R.id.textViewTitle)
        geners=findViewById(R.id.textViewGener)
        tagline=findViewById(R.id.textViewTagline)
        budget=findViewById(R.id.textViewBudget)
        revenue=findViewById(R.id.textViewRevenue)
        overview=findViewById(R.id.textViewOverview)
        castDrpdown=findViewById(R.id.imageButtonCaseDropdown)
        posterRecyclerView=findViewById(R.id.posterRecycleView)
        castRecyclerView=findViewById(R.id.castRecyclerView)
        productionRecyclerView=findViewById(R.id.productionsRecyclerView)
        productionRecyclerView.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        posterRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        castRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter= Adapter4(this,posterList)
        adapter5= Adapter5(this,castList)
        adapter6=Adapter6(this,prodctionList)
        posterRecyclerView.adapter=adapter
        castRecyclerView.adapter=adapter5
        productionRecyclerView.adapter=adapter6
        viewModel.posters.observe(this, Observer {
            //Log.e("Updating the poster adapter",""+it.size)
            adapter.list=it as ArrayList<Poster>
            adapter.notifyDataSetChanged()
            removeDialog()
        })
        viewModel.prodes.observe(this, Observer {
            adapter6.list=it
            adapter6.notifyDataSetChanged()
        })
        viewModel.md.observe(this, Observer {
            md=it
            setValues()
        })
        viewModel.casts.observe(this, Observer {
            adapter5.list=it as ArrayList<People>
            adapter5.notifyDataSetChanged()
            Log.e("Update on Cast",""+it.size)
        })
        if(viewModel.Castdroped){
            castRecyclerView.visibility=View.VISIBLE
            castDrpdown.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
        }
        if(viewModel.Productiodropped){
            productionRecyclerView.visibility=View.VISIBLE
            productionDropdown.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
        }
        productionDropdown.setOnClickListener(this)
        castDrpdown.setOnClickListener(this)
    }

    fun setValues(){
        if(md==null)
            return
        title.text= md!!.title
        tagline.text= md!!.tagline
        budget.text=""+md!!.budget
        revenue.text=""+md!!.revenue
        overview.text=md!!.overview
        var te:String=""
        for(i in md!!.genres)
            te=te+i.name+"\n"
        geners.text=te
    }

    fun removeDialog(){
        if(pd.isShowing)
            pd.dismiss()
    }

    override fun onClick(v: View?) {
        Log.e("Clicked","Handling clickEvent")
        if(v==null)
            return
        if(v.id==R.id.imageButtonCaseDropdown){
            if(viewModel.Castdroped==false){
                castDrpdown.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
                viewModel.Castdroped=true
                castRecyclerView.visibility=View.VISIBLE
            }else{
                castDrpdown.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24)
                viewModel.Castdroped=false
                castRecyclerView.visibility=View.GONE
            }
        }
        else{
            Log.e("TAG","Second Dropdown clicked")
            if(viewModel.Productiodropped==false){
                productionDropdown.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
                productionRecyclerView.visibility=View.VISIBLE
                viewModel.Productiodropped=true
            }else{
                productionDropdown.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24)
                productionRecyclerView.visibility=View.GONE
                viewModel.Productiodropped=false
            }
        }
    }
}