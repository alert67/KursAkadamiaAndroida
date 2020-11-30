package com.mateuszkukiel.kursakademiaandroida.features.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Rick::class], version = 1)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun rickDao(): RickDao
}