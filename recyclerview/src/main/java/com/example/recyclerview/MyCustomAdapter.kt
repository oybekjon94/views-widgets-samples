package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemListLayoutBinding

//constructor biz ozimiz malumotlar listini berishimiz kere
class MyCustomAdapter(val list: List<String>) :
    RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>() {

    private var recyclerViewListener:RecyclerViewListener? = null
    inner class MyViewHolder(val binding: ItemListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // (2)
        init {
           binding.deleteBtn.setOnClickListener {
               recyclerViewListener?.onDeleteBtnClick(adapterPosition)
           }
        }

        //biz title bersak bindingdagi itemga malumotni berib quysin
        fun bind(title: String) {
            binding.titleTv.text = title
        }
    }
    //listener set qilish (1)
    fun setListener(listener:RecyclerViewListener){
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //biz myViewholder yaratish uchun binding kere shuning uchun bindingni create
        val binding =
            ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //endi MyViewHolder create
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //bu yerda qaysi positsiyani chizishimiz kereligi beriladi
        val title = list[position]
        //bu yerga tepadagi methodni chaqirib quyamiz
        holder.bind(title)
    }

}