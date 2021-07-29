package com.example.simpleshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleshoppinglist.view.ItemAdapter
import com.example.simpleshoppinglist.viewmodel.ItemViewModel
import com.example.simpleshoppinglist.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    val itemViewModel: ItemViewModel by viewModels {
        ViewModelFactory((application as ItemApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        val adapter = ItemAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemViewModel.item.observe(this) {
            itens -> itens.let { adapter.submitList(it) }
        }
    }
}