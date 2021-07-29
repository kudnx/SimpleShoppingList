package com.example.simpleshoppinglist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.simpleshoppinglist.entities.Item

@Dao
interface ItemDAO {

    @Query("SELECT * FROM item ORDER BY item_id")
    fun getAllItens(): LiveData<List<Item>>

    @Insert
    fun insertItem(item: Item)

    @Insert
    fun insertItens(list: List<Item>)
}