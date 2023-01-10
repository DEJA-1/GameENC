package com.example.gameenc.data.remote.response

import com.example.gameenc.domain.model.MyPlatformInfo

//PlatformInfo
data class PlatformXX(
    val games_count: Int,
    val id: Int,
    val image: Any,
    val image_background: String,
    val name: String,
    val slug: String,
    val year_end: Any,
    val year_start: Int
)

fun PlatformXX.toMyPlatformInfo(): MyPlatformInfo {
    return MyPlatformInfo(
        id = id,
        name = name,
        slug = slug
    )
}