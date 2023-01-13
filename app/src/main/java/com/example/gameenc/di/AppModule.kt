package com.example.gameenc.di

import android.app.Application
import androidx.room.Room
import com.example.gameenc.common.Constants
import com.example.gameenc.common.Constants.BASE_URL
import com.example.gameenc.data.database.GameDao
import com.example.gameenc.data.database.GameDatabase
import com.example.gameenc.data.remote.GameApi
import com.example.gameenc.data.repository.GameRepositoryImpl
import com.example.gameenc.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGameApi(): GameApi {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(api: GameApi, db: GameDatabase) : GameRepository = GameRepositoryImpl(api, db.gameDao)

    @Provides
    @Singleton
    fun provideGameDatabase(app: Application): GameDatabase {
        return Room.databaseBuilder(
            app,
            GameDatabase::class.java,
            GameDatabase.DATABASE_NAME
        ).build()
    }

    //test

}