package com.arpinesevanyan.starwars.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Character(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String
)

data class Planet(
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    // Добавьте остальные поля, если необходимо
)

data class Film(
    val title: String,
    val episodeId: Int,
    val director: String,
    val releaseDate: String,
)

@Entity(tableName = "starships")
data class Starship(
    @PrimaryKey val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val passengers: String
)

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey val id: Int, // Уникальный идентификатор элемента
    val type: String, // "character" или "starship"
    val name: String,
    val details: String
)
