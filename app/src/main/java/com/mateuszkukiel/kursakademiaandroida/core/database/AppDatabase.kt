package com.mateuszkukiel.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.EpisodeDao
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}