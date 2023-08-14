package com.arpinesevanyan.starwars.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arpinesevanyan.starwars.data.Starship

@Dao
interface StarshipsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(starships: List<Starship>)

    @Query("SELECT * FROM starships")
    fun getAllStarships(): LiveData<List<Starship>>
}


