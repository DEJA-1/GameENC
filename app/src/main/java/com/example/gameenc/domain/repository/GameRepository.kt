package com.example.gameenc.domain.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.data.remote.dto.GameList

interface GameRepository {

    suspend fun getGames() : Resource<GameList>

}