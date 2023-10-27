package com.example.listadapterapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAdapter = MyListAdapter()

        //refreshlayout recyclerViewni ustida bolishi kere
        //bu bir dona viewGroupni qabul qiladi.
        binding.swipeRefresh.setOnRefreshListener {

            //Handler necha sekundan progressbar korinishi uchun
            Handler().postDelayed(Runnable{
                listAdapter.submitList(getTitleList()) //swipeni torganda yangi listlarni olib keladi
                binding.swipeRefresh.isRefreshing = false // progressbarni ochirish
            },5000)
        }

        //progressBarga rang berish
        binding.swipeRefresh.setColorSchemeColors(
            Color.RED,
            Color.GREEN,
            Color.BLACK,
        )

        binding.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        listAdapter.submitList(getTitleList())
    }

    private fun getTitleList():List<String>{
        val list = mutableListOf<String>()
        for (i in 1..100){
            list.add("Title $i")

        }
        return list
    }
}