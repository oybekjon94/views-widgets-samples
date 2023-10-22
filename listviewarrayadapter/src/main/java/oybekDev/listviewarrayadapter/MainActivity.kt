package oybekDev.listviewarrayadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import oybekDev.listviewarrayadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fruits = arrayListOf<String>("olma","nok","banana","shaftoli")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${fruits[position]} tanlandi",Toast.LENGTH_SHORT).show()
            Intent(this,ImageActivity::class.java).apply {
                //apply qilsak qoshimcha variable yaratmaymiz
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}