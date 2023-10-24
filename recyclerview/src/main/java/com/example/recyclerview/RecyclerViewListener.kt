package com.example.recyclerview

//onClickListener create
interface RecyclerViewListener {
    fun onItemClick(position:Int)

    fun onDeleteBtnClick(position: Int)
}