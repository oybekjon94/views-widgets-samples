package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<String>()
        repeat(30){
            list.add("Title $it")
        }
        val customAdapter = MyCustomAdapter(list)

        val myLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.apply {
            adapter = customAdapter
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity,myLayoutManager.orientation))
        }
    }
}