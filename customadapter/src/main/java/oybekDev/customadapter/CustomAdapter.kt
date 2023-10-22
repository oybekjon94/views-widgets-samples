package oybekDev.customadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import oybekDev.customadapter.databinding.FruitItemLayoutBinding

class CustomAdapter(context: Context, val fruitList: ArrayList<FruitModel>) :
    ArrayAdapter<FruitModel>(context,R.layout.fruit_item_layout,fruitList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //ozimizni viewimizni create
        val binding:FruitItemLayoutBinding
        //convertView har bitta kichkina itemi
        //null bolsa create bolmasa ozidan olamiz
        if (convertView == null){
            binding = FruitItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        }else{
            //agarda convertView null bolmasa
            binding = FruitItemLayoutBinding.bind(convertView)
        }

        binding.fruitName.text = fruitList[position].name
        binding.fruitImage.setImageResource(fruitList[position].image)

        //return super.getView(position, convertView, parent) //bu default view
        //lekin bizda kop malumotlar bilan ishlaganda ozimiz tepada yozishimiz kere
        return binding.root
    }
}