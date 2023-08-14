package com.arpinesevanyan.starwars.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.R
import com.arpinesevanyan.starwars.data.Starship

class StarshipAdapter(private val starshipClickListener: StarshipClickListener) :
    RecyclerView.Adapter<StarshipAdapter.StarshipViewHolder>() {

    private val starships: MutableList<Starship> = mutableListOf()

    fun setStarships(starships: List<Starship>) {
        this.starships.clear()
        this.starships.addAll(starships)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_starship, parent, false)
        return StarshipViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {
        holder.bind(starships[position])
    }

    override fun getItemCount(): Int = starships.size

    inner class StarshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val modelTextView: TextView = itemView.findViewById(R.id.modelTextView)
        private val manufacturerTextView: TextView = itemView.findViewById(R.id.manufacturerTextView)
        private val passengersTextView: TextView = itemView.findViewById(R.id.passengersTextView)

        fun bind(starship: Starship) {
            nameTextView.text = starship.name
            modelTextView.text = "Model: ${starship.model}"
            manufacturerTextView.text = "Manufacturer: ${starship.manufacturer}"
            passengersTextView.text = "Passengers: ${starship.passengers}"

            itemView.setOnClickListener {
                starshipClickListener.onStarshipClick(starship)
            }
        }
    }

    interface StarshipClickListener {
        fun onStarshipClick(starship: Starship)
    }
}
