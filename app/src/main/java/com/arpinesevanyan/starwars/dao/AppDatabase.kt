package com.arpinesevanyan.starwars.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arpinesevanyan.starwars.dao.FavoritesDao
import com.arpinesevanyan.starwars.data.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    abstract fun starshipsDao() : StarshipsDao
}
