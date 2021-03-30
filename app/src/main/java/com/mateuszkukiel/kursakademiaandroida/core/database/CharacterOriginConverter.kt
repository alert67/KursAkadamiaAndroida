package com.mateuszkukiel.kursakademiaandroida.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterOriginCached

class CharacterOriginConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: CharacterOriginCached): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): CharacterOriginCached{
            return Gson().fromJson(json, object : TypeToken<CharacterOriginCached>() {}.type)
        }
    }

}