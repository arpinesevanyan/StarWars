package com.arpinesevanyan.starwars.data


data class StarshipResponse(
    val results: List<StarshipResult>
)

data class StarshipResult(
    val name: String,
    val model: String,
    val manufacturer: String,
    val passengers: String
)
