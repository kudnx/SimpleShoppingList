package com.example.simpleshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.simpleshoppinglist.databinding.ActivityRegisterBinding
import com.example.simpleshoppinglist.entities.Item
import com.example.simpleshoppinglist.viewmodel.ItemViewModel
import com.example.simpleshoppinglist.viewmodel.ViewModelFactory

class ActivityRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val itemViewModel: ItemViewModel by viewModels {
        ViewModelFactory((application as ItemApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            itemViewModel.addItem(item = Item(
                name = binding.itemTitleRegister.text.toString(),
                description = binding.itemDescriptionRegister.text.toString(),
                checked = false
                )
            )
        }
    }
}