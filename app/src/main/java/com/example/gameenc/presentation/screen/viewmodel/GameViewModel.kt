package com.example.gameenc.presentation.screen.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameenc.common.Resource
import com.example.gameenc.data.remote.response.toMyGameList
import com.example.gameenc.domain.model.MyGame
import com.example.gameenc.domain.model.MyGameList
import com.example.gameenc.domain.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GameRepository,
) : ViewModel() {

    var gameList = mutableStateOf(MyGameList(listOf()))
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf("")
    val selectedCategory = mutableStateOf("SINGLEPLAYER")
    val selectedCategoryIndex = mutableStateOf(0)
    val selectedGame = mutableStateOf<MyGame>(MyGame(0,
        "",
        "",
        emptyList(),
        emptyList(),
        0,
        0.0,
        0,
        emptyList(),
        0,
        "",
        0,
        0,
        emptyList(),
        "",
        emptyList(),
        emptyList()))
    private val _gameListFromDb = MutableStateFlow<List<MyGame>>(emptyList())
    val gameListFromDb = _gameListFromDb.asStateFlow()

    init {
        getGames()

        viewModelScope.launch(Dispatchers.IO){
            repository.getAllGamesFromDb().collect() {
                _gameListFromDb.value = it
            }
        }
    }

    private fun getGames() {
        viewModelScope.launch() {
            isLoading.value = true
            val result = repository.getGames()

            when (result) {
                is Resource.Success -> {
                    result.data?.results?.forEach {
                        it.tags.map { tag ->
                            tag.name = tag.name.uppercase()
                        }
                    }
                    gameList.value = result.data!!.toMyGameList()
                    isLoading.value = false
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }

    fun insertGameToDb(game: MyGame) = viewModelScope.launch {
        repository.insertGameToDb(game)
    }

    fun deleteGameFromDb(game: MyGame) = viewModelScope.launch {
        repository.deleteGameFromDb(game)
    }



}