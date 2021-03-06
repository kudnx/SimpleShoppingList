package com.example.simpleshoppinglist.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.simpleshoppinglist.database.ItemDAO
import com.example.simpleshoppinglist.entities.Item

class ItemRepository(private val dao: ItemDAO) {
    val itemList: LiveData<List<Item>> = dao.getAllItens()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addNewItem(item: Item){
        dao.insertItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun toggleItemStatus(checked: Boolean, id: Int){
        dao.updateItem(checked, id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun deleteItem(id: Int) {
        dao.deleteItem(id)
    }
}