package com.mateuszkukiel.kursakademiaandroida.core.di

import com.mateuszkukiel.kursakademiaandroida.features.episode.di.episodeModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule
)