package com.example.simpleshoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.simpleshoppinglist.entities.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun ItemDAO(): ItemDAO

    private class ItemDatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.ItemDAO())
                }
            }
        }

        private fun populateDatabase(itemDAO: ItemDAO) {
            val itens = MockItens().getAll()
            itemDAO.insertItens(itens)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "item_database"
                )
                    .addCallback(ItemDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}