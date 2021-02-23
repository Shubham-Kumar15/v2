package com.example.mvvm1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.mvvm1.Adapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var pageAdapter: PageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }
    fun initialize(){
        tabLayout=findViewById(R.id.tab1)
        viewPager=findViewById(R.id.pager1)
        pageAdapter= PageAdapter(supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter=pageAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}