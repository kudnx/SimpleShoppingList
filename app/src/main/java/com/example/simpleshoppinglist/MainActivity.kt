package com.example.simpleshoppinglist

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleshoppinglist.databinding.ActivityMainBinding
import com.example.simpleshoppinglist.databinding.ItemBinding
import com.example.simpleshoppinglist.entities.Item
import com.example.simpleshoppinglist.view.ItemAdapter
import com.example.simpleshoppinglist.view.RecyclerViewClickListener
import com.example.simpleshoppinglist.viewmodel.ItemViewModel
import com.example.simpleshoppinglist.viewmodel.ViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {
    private lateinit var binding: ActivityMainBinding
    private val itemViewModel: ItemViewModel by viewModels {
        ViewModelFactory((application as ItemApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.itemRecyclerView
        val adapter = ItemAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemViewModel.item.observe(this) {
            itens -> itens.let { adapter.submitList(it) }
        }

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        }
    }

    override fun onRecyclerViewItemClick(view: View, item: Item) {
        Toast.makeText(this, "$item", Toast.LENGTH_LONG).show()
    }
}