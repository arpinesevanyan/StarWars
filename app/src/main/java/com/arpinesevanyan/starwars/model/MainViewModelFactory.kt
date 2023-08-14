package com.arpinesevanyan.starwars.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arpinesevanyan.starwars.repo.StarWarsApiService

class MainViewModelFactory(private val apiService: StarWarsApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
