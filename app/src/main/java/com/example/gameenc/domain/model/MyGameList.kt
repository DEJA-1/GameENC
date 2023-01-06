package com.example.gameenc.domain.model

import com.example.gameenc.data.remote.dto.Filters
import com.example.gameenc.data.remote.dto.Game

data class MyGameList(
    val results: List<MyGame>,
)
