package com.arpinesevanyan.starwars.dao

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.arpinesevanyan.starwars.data.Favorite
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorite WHERE type = :type")
    fun getFavoritesByType(type: String): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}

@Database(entities = [Favorite::class], version = 1)
abstract class YourDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}

object DatabaseManager {
    private var instance: YourDatabase? = null

    fun getDatabase(context: Context): YourDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                YourDatabase::class.java,
                "favorites.db"
            ).build()
        }
        return instance!!
    }
}


