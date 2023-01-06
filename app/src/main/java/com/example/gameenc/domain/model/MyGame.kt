package com.example.gameenc.domain.model

import com.example.gameenc.data.remote.dto.*

data class MyGame(
    val background_image: String,
    val genres: List<Genre>,
    val id: Int,
    val name: String,
    val platforms: List<MyPlatform>,
    val playtime: Int,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<Rating>,
    val ratings_count: Int,
    val released: String,
    val reviews_count: Int,
    val reviews_text_count: Int,
    val short_screenshots: List<ShortScreenshot>,
    val slug: String,
    val stores: List<Store>,
    val tags: List<Tag>,
)
