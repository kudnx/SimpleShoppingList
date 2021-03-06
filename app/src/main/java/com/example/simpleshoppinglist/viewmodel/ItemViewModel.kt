package com.example.simpleshoppinglist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleshoppinglist.entities.Item
import com.example.simpleshoppinglist.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemViewModel(private val repository: ItemRepository): ViewModel() {
    val item: LiveData<List<Item>> = repository.itemList

    fun addItem(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNewItem(item)
    }

    fun toggleItemStatus(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.toggleItemStatus(!item.checked, item.id)
    }

    fun deleteItem(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteItem(id)
    }
}