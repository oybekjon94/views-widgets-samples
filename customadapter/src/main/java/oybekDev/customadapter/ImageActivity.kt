package oybekDev.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import oybekDev.customadapter.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private val fruits = arrayListOf<String>("olma","nok","banana")
    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)

        supportActionBar?.title = fruits[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0 -> binding.imageView.setImageResource(R.drawable.olma)
            1 -> binding.imageView.setImageResource(R.drawable.pear)
            2 -> binding.imageView.setImageResource(R.drawable.olma)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}