package com.arpinesevanyan.starwars.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "https://swapi.dev/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: StarWarsApiService = retrofit.create(StarWarsApiService::class.java)
}
