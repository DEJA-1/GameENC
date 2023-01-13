package com.example.gameenc.data.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.data.database.GameDao
import com.example.gameenc.data.remote.GameApi
import com.example.gameenc.data.remote.response.GameList
import com.example.gameenc.domain.model.MyGame
import com.example.gameenc.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val api: GameApi,
    private val dao: GameDao
) : GameRepository{

    override suspend fun getGames(): Resource<GameList> {

        val response = try {
            api.getGames()
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage!!)
        }

        return Resource.Success(response)
    }

    override fun getAllGamesFromDb(): Flow<List<MyGame>> {
        return dao.getAllGamesFromDb().flowOn(Dispatchers.IO).conflate()
    }

    override suspend fun insertGameToDb(game: MyGame) {
        dao.insertGameToDb(game)
    }

    override suspend fun deleteGameFromDb(game: MyGame) {
        dao.deleteGameFromDb(game)
    }

}