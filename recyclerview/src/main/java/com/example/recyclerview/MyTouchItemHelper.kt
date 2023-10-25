package com.example.recyclerview

import android.content.ClipData.Item
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

//biz abstrack func qilmoqchi bolsak classni xam abstrack qilishimiz kere
abstract class MyTouchItemHelper() :
    ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.DOWN or ItemTouchHelper.UP,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder, //qaysi item kochmoqchi
        target: RecyclerView.ViewHolder,     //qayerga kochmoqchi
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition  // 1
        val toPosition = target.adapterPosition

        //onMove func da abstrack func ni chaqirib quyamiz // 3
        onItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        onItemSwipedToDelete(viewHolder.adapterPosition)
    }

    abstract fun onItemSwipedToDelete(position: Int)

    //endi bu yerda drop qilish uchun func kere    // 2
    abstract fun onItemMoved(from: Int, to: Int)
}
