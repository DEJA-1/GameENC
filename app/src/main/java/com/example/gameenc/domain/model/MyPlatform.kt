package com.example.gameenc.domain.model

import com.example.gameenc.data.remote.response.RequirementsEn


data class MyPlatform(
    val platform_info: MyPlatformInfo,
    val requirements_en: RequirementsEn?,
)
