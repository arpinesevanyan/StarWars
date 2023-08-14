package com.arpinesevanyan.starwars.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.R
import com.arpinesevanyan.starwars.data.Favorite

class FavoritesAdapter : ListAdapter<Favorite, FavoritesAdapter.FavoriteViewHolder>(FavoriteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = getItem(position)
        holder.bind(favorite)
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val detailsTextView: TextView = itemView.findViewById(R.id.detailsTextView)

        fun bind(favorite: Favorite) {
            nameTextView.text = favorite.name
            detailsTextView.text = favorite.details
        }
    }

    private class FavoriteDiffCallback : DiffUtil.ItemCallback<Favorite>() {
        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem == newItem
        }
    }
}
