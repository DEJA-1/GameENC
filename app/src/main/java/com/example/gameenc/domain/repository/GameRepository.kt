package com.example.gameenc.domain.repository

import com.example.gameenc.common.Resource
import com.example.gameenc.data.remote.dto.GameList
import com.example.gameenc.domain.model.MyGameList

interface GameRepository {

    suspend fun getGames() : Resource<MyGameList>

}