package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.example.gridview.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityImageBinding
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
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)

        supportActionBar?.title = imageList[position].toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0 -> binding.imageView2.setImageResource(R.drawable.olma)
            1 -> binding.imageView2.setImageResource(R.drawable.pear)
            2 -> binding.imageView2.setImageResource(R.drawable.olma2)
            3 -> binding.imageView2.setImageResource(R.drawable.pear2)
            4 -> binding.imageView2.setImageResource(R.drawable.olma3)
            5 -> binding.imageView2.setImageResource(R.drawable.pear3)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}