package com.arpinesevanyan.starwars.repo

import androidx.lifecycle.LiveData
import com.arpinesevanyan.starwars.dao.FavoritesDao
import com.arpinesevanyan.starwars.data.Favorite

class FavoritesRepository(private val favoritesDao: FavoritesDao) {

    fun getFavoriteCharacters(): LiveData<List<Favorite>> {
        return favoritesDao.getFavoritesByType("character")
    }

    fun getFavoriteStarships(): LiveData<List<Favorite>> {
        return favoritesDao.getFavoritesByType("starship")
    }

    suspend fun addToFavorites(favorite: Favorite) {
        favoritesDao.insertFavorite(favorite)
    }

    suspend fun removeFromFavorites(favorite: Favorite) {
        favoritesDao.deleteFavorite(favorite)
    }
}

