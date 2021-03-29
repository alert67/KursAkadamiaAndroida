package com.mateuszkukiel.kursakademiaandroida.core.di

import androidx.room.Room
import com.mateuszkukiel.kursakademiaandroida.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "appDatabase"
        )
            .build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().locationDao() }
    single { get<AppDatabase>().characterDao() }
}