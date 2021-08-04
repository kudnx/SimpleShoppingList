package com.example.simpleshoppinglist.database

import com.example.simpleshoppinglist.entities.Item

class MockItens {
    public fun getAll(): List<Item> {
        return listOf<Item>(
            Item(
                name = "Doce de leite",
                description = "500 gramas",
                checked = true
            ),
            Item(
                name = "Queijo",
                description = "2",
                checked = false
            )
        )
    }
}