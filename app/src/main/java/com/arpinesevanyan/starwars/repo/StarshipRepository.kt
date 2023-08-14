package com.arpinesevanyan.starwars.repo


import androidx.lifecycle.LiveData
import com.arpinesevanyan.starwars.dao.StarshipsDao
import com.arpinesevanyan.starwars.data.Starship

class StarshipRepository(private val starshipsDao: StarshipsDao) {

    suspend fun saveStarships(starships: List<Starship>) {
        starshipsDao.insertStarships(starships)
    }

    suspend fun getAllStarships(): LiveData<List<Starship>> {
        return starshipsDao.getAllStarships()
    }
}
