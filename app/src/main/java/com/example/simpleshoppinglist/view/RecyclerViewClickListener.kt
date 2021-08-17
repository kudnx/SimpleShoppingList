package com.example.simpleshoppinglist.view

import android.view.View
import com.example.simpleshoppinglist.entities.Item

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, item: Item)
}