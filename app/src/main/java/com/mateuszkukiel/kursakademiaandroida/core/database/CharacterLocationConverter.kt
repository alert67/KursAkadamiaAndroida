package com.mateuszkukiel.kursakademiaandroida.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterLocationCached

class CharacterLocationConverter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: CharacterLocationCached): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): CharacterLocationCached {
            return Gson().fromJson(json, object : TypeToken<CharacterLocationCached>() {}.type)
        }
    }
}