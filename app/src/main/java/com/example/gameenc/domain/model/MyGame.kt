package com.example.gameenc.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gameenc.data.remote.response.*

@Entity(tableName = "game_table")
data class MyGame(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image")
    val background_image: String,
    @ColumnInfo(name = "genre")
    val genres: List<Genre>,
    @ColumnInfo(name = "platforms")
    val platforms: List<MyPlatform>,
    @ColumnInfo(name = "playtime")
    val playtime: Int,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "rating_top")
    val rating_top: Int,
    @ColumnInfo(name = "ratings")
    val ratings: List<Rating>,
    @ColumnInfo(name = "ratings_count")
    val ratings_count: Int,
    @ColumnInfo(name = "released_data")
    val released: String,
    @ColumnInfo(name = "reviews_count")
    val reviews_count: Int,
    @ColumnInfo(name = "reviews_text_count")
    val reviews_text_count: Int,
    @ColumnInfo(name = "screenshots")
    val short_screenshots: List<ShortScreenshot>,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "stores")
    val stores: List<Store>,
    @ColumnInfo(name = "tags")
    val tags: List<Tag>,
)
