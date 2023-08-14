package com.arpinesevanyan.starwars.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.R
import com.arpinesevanyan.starwars.data.Character
import com.arpinesevanyan.starwars.data.CharacterResult

class CharacterAdapter(private val listener: CharacterClickListener) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters: MutableList<CharacterResult> = mutableListOf()

    fun setCharacters(characterList: List<Character>) {
        characters.clear()
        characters.addAll(characters)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterResult = characters[position]
        val character = characterResult.character // Предположим, что CharacterResult содержит поле character
        holder.bind(character)
        holder.itemView.setOnClickListener {
            listener.onCharacterClick(character)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val characterNameTextView: TextView = itemView.findViewById(R.id.characterNameTextView)
        private val characterHeightTextView: TextView = itemView.findViewById(R.id.characterHeightTextView)

        fun bind(character: Character) {
            characterNameTextView.text = character.name
            characterHeightTextView.text = "Height: ${character.height}"
        }
    }

    interface CharacterClickListener {
        fun onCharacterClick(character: Character)
    }
}


