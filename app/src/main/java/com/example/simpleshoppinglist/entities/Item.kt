package com.example.simpleshoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val id: Int = 0,
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_description")
    val description: String,
    @ColumnInfo(name = "item_checked")
    val checked: Boolean
)
