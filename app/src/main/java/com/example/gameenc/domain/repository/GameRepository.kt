package com.example.gameenc.domain.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.data.remote.response.GameList
import com.example.gameenc.domain.model.MyGame
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getGames() : Resource<GameList>

    fun getAllGamesFromDb(): Flow<List<MyGame>>

    suspend fun insertGameToDb(game: MyGame)

    suspend fun deleteGameFromDb(game: MyGame)
}