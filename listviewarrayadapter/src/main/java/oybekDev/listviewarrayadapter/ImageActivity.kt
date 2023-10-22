package oybekDev.listviewarrayadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import oybekDev.listviewarrayadapter.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private val fruits = arrayListOf<String>("olma","nok","banana","shaftoli")


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
            3 -> binding.imageView.setImageResource(R.drawable.pear)
        }
    }
    //orqaga bosish tugmasi bosilganda activityni finish qilish
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}