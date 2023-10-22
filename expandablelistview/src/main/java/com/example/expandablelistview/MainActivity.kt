package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expandablelistview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val groupList = mutableListOf<String>()
        val childMap = mutableMapOf<String,List<String>>() //bu yerdagi birinchi string
        // tepadagi grouplist

        repeat(5){//bu yerda nechidan boshlansin
            groupList.add("Group $it")
            //birinchi marta aylanganda nechta child qushamiz
            //random tarzda beramiz

            val childNumber = Random.nextInt(10)

            //childlarni ushlab turadigan list
            val tempList = mutableListOf<String>()

            repeat(childNumber){childId ->
                tempList.add("Child $childId in Group $it")
            }
            //groupda childId bor endi childMapga qushamiz
            childMap["Group $it"] = tempList
        }

        val adapter = CustomAdapter(this,groupList,childMap)
        binding.expandableListView.setAdapter(adapter)
        
        binding.expandableListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
            val groupName = groupList[groupPosition]
            val childName = childMap[groupName]!![childPosition]
            Toast.makeText(this,childName,Toast.LENGTH_SHORT).show()
            true
        }
    }
}