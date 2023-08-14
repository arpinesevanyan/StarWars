package com.arpinesevanyan.starwars.data

data class CharacterResponse(
    val results: List<CharacterResult>
)

data class CharacterResult(
    val name: String,
    val gender: String,
    val starships: List<String>,
    val character: com.arpinesevanyan.starwars.data.Character
)