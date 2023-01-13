package com.example.gameenc.common

import androidx.room.TypeConverter
import com.example.gameenc.data.remote.response.*
import com.example.gameenc.domain.model.MyPlatform
import com.example.gameenc.domain.model.MyPlatformInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    //Genre
    @TypeConverter
    fun fromStringGenre(value: String): List<Genre> {
        val listType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListGenre(list: List<Genre>): String {
        return Gson().toJson(list)
    }

    //MyPlatformInfo
    @TypeConverter
    fun fromStringMyPlatformInfo(value: String): MyPlatformInfo {
        return Gson().fromJson(value, MyPlatformInfo::class.java)
    }

    @TypeConverter
    fun fromMyPlatformInfo(platformInfo: MyPlatformInfo): String {
        return Gson().toJson(platformInfo)
    }

    //MyPlatform
    @TypeConverter
    fun fromStringMyPlatform(value: String): List<MyPlatform> {
        val listType = object : TypeToken<List<MyPlatform>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListMyPlatform(list: List<MyPlatform>): String {
        return Gson().toJson(list)
    }

    //Ratings
    @TypeConverter
    fun fromStringRating(value: String): List<Rating> {
        val listType = object : TypeToken<List<Rating>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListRating(list: List<Rating>): String {
        return Gson().toJson(list)
    }

    //Screenshot
    @TypeConverter
    fun fromStringScreenShot(value: String): List<ShortScreenshot> {
        val listType = object : TypeToken<List<ShortScreenshot>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListScreenShot(list: List<ShortScreenshot>): String {
        return Gson().toJson(list)
    }

    //Store
    @TypeConverter
    fun fromStringStore(value: String): List<Store> {
        val listType = object : TypeToken<List<Store>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListStore(list: List<Store>): String {
        return Gson().toJson(list)
    }

    //StoreX
    @TypeConverter
    fun fromStringStoreX(value: String): StoreX {
        return Gson().fromJson(value, StoreX::class.java)
    }

    @TypeConverter
    fun fromStoreX(storeX: StoreX): String {
        return Gson().toJson(storeX)
    }

    //Tag
    @TypeConverter
    fun fromStringTag(value: String): List<Tag> {
        val listType = object : TypeToken<List<Tag>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListTag(list: List<Tag>): String {
        return Gson().toJson(list)
    }


}