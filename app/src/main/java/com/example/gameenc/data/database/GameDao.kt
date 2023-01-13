package com.example.gameenc.data.database

import androidx.room.*
import com.example.gameenc.domain.model.MyGame
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM game_table")
    fun getAllGamesFromDb(): Flow<List<MyGame>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameToDb(game: MyGame)

    @Delete
    suspend fun deleteGameFromDb(game: MyGame)
}