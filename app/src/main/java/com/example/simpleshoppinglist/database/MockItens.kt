package com.example.simpleshoppinglist.database

import com.example.simpleshoppinglist.entities.Item

class MockItens {
    public fun getAll(): List<Item> {
        return listOf<Item>(
            Item(
                name = "Chocolate",
                description = "muitos",
                checked = true
            ),
            Item(
                name = "Queijo",
                description = "mt bom",
                checked = true
            ),
            Item(
                name = "Miojo",
                description = "dezenas",
                checked = true
            ),
            Item(
                name = "carne",
                description = "one",
                checked = false
            ),
            Item(
                name = "bebida",
                description = "also one",
                checked = false
            ),
        )
    }
}