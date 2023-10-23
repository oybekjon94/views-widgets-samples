package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemGalleryLayoutBinding

class GalleryAdapter(val imageList: List<Int>) :
    RecyclerView.Adapter<GalleryAdapter.MyGallerViewHolder>() {
    inner class MyGallerViewHolder(val binding: ItemGalleryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageId: Int) {
            binding.imageView.setImageResource(imageId)
        }
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