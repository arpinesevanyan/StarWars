package com.arpinesevanyan.starwars.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arpinesevanyan.starwars.repo.StarWarsApiService
import com.arpinesevanyan.starwars.data.Starship
import kotlinx.coroutines.launch
import com.arpinesevanyan.starwars.data.Character
import com.arpinesevanyan.starwars.repo.StarshipRepository

class MainViewModel(private val apiService: StarWarsApiService) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    private val _starships = MutableLiveData<List<Starship>>()
    val starships: MutableLiveData<List<Starship>> = _starships

    private val _selectedCharacter = MutableLiveData<Character>()
    val selectedCharacter: LiveData<Character> = _selectedCharacter

    private val _selectedStarship = MutableLiveData<Starship>()
    val selectedStarship: LiveData<Starship> = _selectedStarship

    fun searchCharacters(query: String) {
        viewModelScope.launch {
            val response = apiService.searchCharacters(query)
            if (response.isSuccessful) {
                _characters.postValue((response.body()?.results ?: emptyList()) as List<Character>?)
            }
        }
    }

    fun searchStarships(query: String) {
        viewModelScope.launch {
            val response = apiService.searchStarships(query)
            if (response.isSuccessful) {
                _starships.postValue((response.body()?.results ?: emptyList()) as List<Starship>?)
            }
        }
    }

    fun selectCharacter(character: Character) {
        _selectedCharacter.value = character
    }

    fun selectStarship(starship: Starship) {
        _selectedStarship.value = starship
    }

    fun getPlanet(planetId: Int) {
        viewModelScope.launch {
            val response = apiService.getPlanet(planetId)
            if (response.isSuccessful) {
                val planet = response.body()
                // Обработка планеты, если необходимо
            }
        }
    }
}
