package com.example.gameenc.data.remote

import com.example.gameenc.common.Constants
import com.example.gameenc.data.remote.dto.GameList
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface GameApi {

    @GET(value = "games")
    suspend fun getGames(
        @Query("key") key: String = Constants.API_KEY
    ) : GameList

}