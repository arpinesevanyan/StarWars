package com.arpinesevanyan.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.adapters.CharacterAdapter
import com.arpinesevanyan.starwars.data.Character
import com.arpinesevanyan.starwars.model.MainViewModel

class CharacterFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        characterAdapter = CharacterAdapter(object : CharacterAdapter.CharacterClickListener {
            override fun onCharacterClick(character: Character) {
                // Handle the character click event if needed
            }
        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            characterAdapter.setCharacters(characters)
            characterAdapter.notifyDataSetChanged() // Вот здесь добавлена строка для обновления адаптера
        })

        return view
    }
}

