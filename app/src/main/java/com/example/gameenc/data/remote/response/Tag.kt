package com.example.gameenc.data.remote.response

data class Tag(
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val language: String,
    var name: String,
    val slug: String
)