package com.example.gameenc.data.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.data.remote.GameApi
import com.example.gameenc.data.remote.dto.GameList
import com.example.gameenc.data.remote.dto.toMyGameList
import com.example.gameenc.domain.model.MyGameList
import com.example.gameenc.domain.repository.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val api: GameApi
) : GameRepository{

    override suspend fun getGames(): Resource<MyGameList> {

        val response = try {
            api.getGames().toMyGameList()
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage!!)
        }

        return Resource.Success(response)
    }

}