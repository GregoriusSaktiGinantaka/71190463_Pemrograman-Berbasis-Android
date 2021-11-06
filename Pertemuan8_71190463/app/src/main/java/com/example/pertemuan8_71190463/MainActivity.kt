package com.example.pertemuan8_71190463

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.pager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = PageAdapter (supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}