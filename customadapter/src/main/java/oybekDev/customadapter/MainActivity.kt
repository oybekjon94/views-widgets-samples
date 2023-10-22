package oybekDev.customadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import oybekDev.customadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fruits = arrayListOf<FruitModel>(
        FruitModel("olma",R.drawable.olma),
        FruitModel("uzum",R.drawable.pear),
        FruitModel("nok",R.drawable.olma)
    )
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomAdapter(this,fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${fruits[position]} tanlndi",Toast.LENGTH_SHORT).show()
            Intent(this,ImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}