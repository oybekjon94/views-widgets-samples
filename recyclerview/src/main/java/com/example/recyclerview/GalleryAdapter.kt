package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemGalleryLayoutBinding

class GalleryAdapter(val imageList: List<Int>) :
    RecyclerView.Adapter<GalleryAdapter.MyGallerViewHolder>() {

    // 2) bu listener ushlab turadi
    //mobodo recyclerView bermasak crash bermasligi uchun nullable
    private var recyclerViewListener:RecyclerViewListener? = null
    inner class MyGallerViewHolder(val binding: ItemGalleryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // 3) bu yerda item click bolganini sezish uchun ViewHolderga beramiz
        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }

        fun bind(imageId: Int) {
            binding.imageView.setImageResource(imageId)
        }
    }

    // 1) activitydan Listener beramiz
    fun setListener(listener:RecyclerViewListener){
          recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGallerViewHolder {
        return MyGallerViewHolder(
            ItemGalleryLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: MyGallerViewHolder, position: Int) {
        holder.bind(imageList[position])
    }
}