package com.arpinesevanyan.starwars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.adapters.FavoritesAdapter
import com.arpinesevanyan.starwars.model.FavoritesViewModel

class FavoritesActivity : AppCompatActivity() {

    private lateinit var viewModel: FavoritesViewModel
    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        favoritesAdapter = FavoritesAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = favoritesAdapter

        viewModel.favoriteCharacters.observe(this, Observer { favorites ->
            favoritesAdapter.submitList(favorites)
        })

        viewModel.favoriteStarships.observe(this, Observer { favorites ->
            favoritesAdapter.submitList(favorites)
        })
    }
}




