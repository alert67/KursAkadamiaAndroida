package com.mateuszkukiel.kursakademiaandroida.core.di

import androidx.room.Room
import com.mateuszkukiel.kursakademiaandroida.features.data.RickAndMortyDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RickAndMortyDatabase::class.java,
            "rick_and_morty"
        )
            .build()
    }
}