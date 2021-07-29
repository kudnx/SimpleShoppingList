package com.example.simpleshoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleshoppinglist.repository.ItemRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: ItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("View Model Not Found!")
    }
}