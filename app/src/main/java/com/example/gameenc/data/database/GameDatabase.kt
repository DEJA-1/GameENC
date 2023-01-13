package com.example.gameenc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gameenc.common.Converters
import com.example.gameenc.domain.model.MyGame

@Database(entities = [MyGame::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameDatabase : RoomDatabase() {

    abstract val gameDao: GameDao

    companion object {
        const val DATABASE_NAME = "game_table"
    }

}