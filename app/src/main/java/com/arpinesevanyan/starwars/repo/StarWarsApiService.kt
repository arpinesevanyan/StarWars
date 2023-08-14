package com.arpinesevanyan.starwars.repo

import com.arpinesevanyan.starwars.data.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApiService {
    @GET("people/{id}/")
    suspend fun getCharacter(@Path("id") characterId: Int): Response<Character>

    @GET("films/{id}/")
    suspend fun getFilm(@Path("id") filmId: Int): Response<Film>

    @GET("starships/")
    suspend fun getStarships(): Response<StarshipResponse>

    @GET("planets/{id}/")
    suspend fun getPlanet(@Path("id") planetId: Int): Response<Planet>

    @GET("people/")
    suspend fun searchCharacters(@Query("search") query: String): Response<CharacterResponse>

    @GET("starships/")
    suspend fun searchStarships(@Query("search") query: String): Response<StarshipResponse>

}






