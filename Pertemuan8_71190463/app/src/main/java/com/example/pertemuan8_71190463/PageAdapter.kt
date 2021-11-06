package com.example.pertemuan8_71190463

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
        when(position){
            0 -> {return FirstFragment()}
            1 -> {return SecondFragment()}
            2 -> {return ThirdFragment()}
            else -> {return FirstFragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position){
            0 -> {return "Firts"}
            1 -> {return "Second"}
            2 -> {return "Third"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
        return 3
    }

}