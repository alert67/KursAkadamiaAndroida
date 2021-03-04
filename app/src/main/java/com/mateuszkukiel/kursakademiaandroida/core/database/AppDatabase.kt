package com.mateuszkukiel.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.CharacterDao
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterCached
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.EpisodeDao
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import com.mateuszkukiel.kursakademiaandroida.features.location.data.local.LocationDao
import com.mateuszkukiel.kursakademiaandroida.features.location.data.local.model.LocationCached

@Database(entities = [EpisodeCached::class, LocationCached::class, CharacterCached::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
    abstract fun characterDao(): CharacterDao
}