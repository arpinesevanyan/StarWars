package com.arpinesevanyan.starwars.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.arpinesevanyan.starwars.dao.FavoritesDao
import com.arpinesevanyan.starwars.dao.YourDatabase
import com.arpinesevanyan.starwars.data.Favorite
import com.arpinesevanyan.starwars.repo.FavoritesRepository

class FavoritesViewModel(context: Context) : ViewModel() {

    private val favoritesRepository: FavoritesRepository

    init {
        val favoritesDao = createFavoritesDao(context)
        favoritesRepository = FavoritesRepository(favoritesDao)
    }

    val favoriteCharacters: LiveData<List<Favorite>> = favoritesRepository.getFavoriteCharacters()
    val favoriteStarships: LiveData<List<Favorite>> = favoritesRepository.getFavoriteStarships()

    suspend fun addToFavorites(favorite: Favorite) {
        favoritesRepository.addToFavorites(favorite)
    }

    suspend fun removeFromFavorites(favorite: Favorite) {
        favoritesRepository.removeFromFavorites(favorite)
    }

    private fun createFavoritesDao(context: Context): FavoritesDao {
        val database = Room.databaseBuilder(
            context,
            YourDatabase::class.java,
            "favorites.db"
        ).build()

        return database.favoritesDao()
    }
}


