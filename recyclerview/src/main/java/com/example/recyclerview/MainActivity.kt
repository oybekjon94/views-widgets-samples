package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<String>()
        repeat(30) {
            list.add("Title $it")
        }
        val customAdapter = MyCustomAdapter(list)

        val myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerView.apply {
            adapter = customAdapter
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity, myLayoutManager.orientation))
        }

        customAdapter.setListener(object : RecyclerViewListener {
            override fun onItemClick(position: Int) {

            }

            override fun onDeleteBtnClick(position: Int) {
                //listdan xam ochirib tashash kere
                list.removeAt(position)
                customAdapter.notifyItemRemoved(position)
            }

        })
        val itemTouchHelper = ItemTouchHelper(object :MyTouchItemHelper(){
            override fun onItemSwipedToDelete(position: Int) {
                val removedTitle = list.removeAt(position)  // *
                customAdapter.notifyItemRemoved(position)

                //delete bolgan itemni yana joyiga qaytarish
                Snackbar.make(this@MainActivity,binding.recyclerView,"$removedTitle is going to removed",Snackbar.LENGTH_SHORT)
                    .setAction("Tiklash"){
                        list.add(position,removedTitle) //yani shu poositionga removed titleni qushamiz
                        customAdapter.notifyItemInserted(position)
                    }.show()
            }

            override fun onItemMoved(from: Int, to: Int) {
                Collections.swap(list,from,to)
                customAdapter.notifyItemMoved(from,to)
            }
        })

        //endi shu ItemTouchHelperni recyclerViewga boglab quyamiz
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

        binding.addBtn.setOnClickListener {
            val title = binding.titleEt.text.toString()
            //yangi list create
            val newList = mutableListOf<String>() // 1
            newList.addAll(list)
            if (title.isNotBlank()) {
                list.add(title.trim())
                customAdapter.submitList(newList)  // 2

                //malumotni send qilgandan keyin
                //send joyini clear qilish
                binding.titleEt.text.clear()
            }
        }
    }
}