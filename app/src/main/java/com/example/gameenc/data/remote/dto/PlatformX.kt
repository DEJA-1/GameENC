package com.example.gameenc.data.remote.dto

import com.example.gameenc.domain.model.MyPlatform

//Platform
data class PlatformX(
    val platform: PlatformXX,
    val released_at: String,
    val requirements_en: RequirementsEn,
    val requirements_ru: RequirementsRu
)

fun PlatformX.toMyPlatform() : MyPlatform {
    return MyPlatform(
        platform_info = platform.toMyPlatformInfo(),
        requirements_en = requirements_en
    )
}