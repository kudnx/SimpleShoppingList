package com.example.simpleshoppinglist

import android.app.Application
import com.example.simpleshoppinglist.database.ItemDatabase
import com.example.simpleshoppinglist.repository.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ItemApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ItemDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ItemRepository(database.ItemDAO()) }
}