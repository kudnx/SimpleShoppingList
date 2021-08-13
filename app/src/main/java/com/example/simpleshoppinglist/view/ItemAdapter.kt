package com.example.simpleshoppinglist.view

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleshoppinglist.R
import com.example.simpleshoppinglist.entities.Item

class ItemAdapter: ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemComparator()) {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        private val itemDescription: TextView = itemView.findViewById(R.id.itemDescription)
        private val itemCheckbox: CheckBox = itemView.findViewById(R.id.itemCheckbox)

        fun bind(item: Item){
            itemTitle.text = item.name
            itemCheckbox.isChecked = item.checked

            if (item.description.isEmpty()){
                itemDescription.text = "";
                itemDescription.visibility = View.GONE
            } else {
                itemDescription.text = item.description
            }

            itemCheckbox.setOnClickListener {
                if (itemCheckbox.isChecked) {
                    itemTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                    itemDescription.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                    itemTitle.paintFlags = 0
                    itemDescription.paintFlags = 0
                }
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item, parent, false)
                return ItemViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class ItemComparator: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return  oldItem.id == newItem.id
        }

    }
}