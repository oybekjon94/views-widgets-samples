package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview.databinding.ActivityGalleryBinding
import com.example.recyclerview.databinding.ActivityMainBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf<Int>(
            R.drawable.olma,
            R.drawable.pear,
            R.drawable.olma,
            R.drawable.pear,
            R.drawable.olma,
            R.drawable.pear
        )
        val galleryAdapter = GalleryAdapter(list)
        val myManager  = StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)

        binding.recyclerView.apply {
            adapter = galleryAdapter
            layoutManager = myManager
        }
        // 4) listenerni adapterga berish kere
        galleryAdapter.setListener(object :RecyclerViewListener{
            override fun onItemClick(position: Int) {
                Intent(this@GalleryActivity,ImageViewActivity::class.java).apply {
                    putExtra("image",list[position])
                    startActivity(this)
                }
            }

            override fun onDeleteBtnClick(position: Int) {

            }
        })
    }
}