package com.example.gridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val imageList = arrayListOf<Int>(
        R.drawable.olma,
        R.drawable.pear,
        R.drawable.olma2,
        R.drawable.pear2,
        R.drawable.olma3,
        R.drawable.pear3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GalleryAdapter(this,imageList)
        binding.gridView.adapter = adapter

        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"$position tanlandi",Toast.LENGTH_SHORT).show()
            Intent(this,ImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}