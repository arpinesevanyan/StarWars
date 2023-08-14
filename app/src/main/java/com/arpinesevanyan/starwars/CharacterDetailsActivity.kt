package com.arpinesevanyan.starwars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arpinesevanyan.starwars.databinding.ActivityCharacterDetailsBinding
import com.arpinesevanyan.starwars.model.MainViewModel

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.selectedCharacter.observe(this, { character ->
            binding.nameTextView.text = character.name
            binding.genderTextView.text = "Gender: ${character.gender}"
            binding.starshipCountTextView.text = "Starships: ${character.starships.size}"
        })
    }
}



