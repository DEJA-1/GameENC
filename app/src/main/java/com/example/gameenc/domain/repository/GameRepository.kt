package com.example.gameenc.domain.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.domain.model.GameList

interface GameRepository {

    suspend fun getGames() : Resource<GameList>

}