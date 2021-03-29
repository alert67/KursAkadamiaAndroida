package com.mateuszkukiel.kursakademiaandroida.features.episode.di

import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.EpisodeRepository
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.repository.EpisodeRepositoryImpl
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.GetEpisodesUseCase
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.EpisodeFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get())  }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}