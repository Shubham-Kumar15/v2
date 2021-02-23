package com.example.mvvm1.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mvvm1.FRAGMENTS.MoviesFragment
import com.example.mvvm1.FRAGMENTS.SeriesFragment
class PageAdapter(var fragmentManager: FragmentManager,var behavior:Int) : FragmentPagerAdapter(fragmentManager,behavior) {
    val tabCount:Int=behavior
    override fun getCount(): Int {
        return behavior
    }

    override fun getItem(position: Int): Fragment {
        if(position==0)return MoviesFragment()
        return SeriesFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position==0)
            return "MOVIES"
        return "SERIES"
    }
}