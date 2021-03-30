package com.mateuszkukiel.kursakademiaandroida.core.di

import com.mateuszkukiel.kursakademiaandroida.features.character.di.characterModule
import com.mateuszkukiel.kursakademiaandroida.features.episode.di.episodeModule
import com.mateuszkukiel.kursakademiaandroida.features.location.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule, characterModule, locationModule
)