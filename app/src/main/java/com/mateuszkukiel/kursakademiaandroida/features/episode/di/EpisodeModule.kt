package com.mateuszkukiel.kursakademiaandroida.features.episode.di

import com.mateuszkukiel.kursakademiaandroida.features.episode.data.repository.EpisodeRepositoryImpl
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.EpisodeRepository
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.GetEpisodesUseCase
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.EpisodeFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.EpisodeViewModel
import com.mateuszkukiel.kursakademiaandroida.features.episode.details.presentation.EpisodeDetailsFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.details.presentation.EpisodeDetailsViewModel
import com.mateuszkukiel.kursakademiaandroida.features.episode.navigation.EpisodeNavigator
import com.mateuszkukiel.kursakademiaandroida.features.episode.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation all
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
    viewModel { EpisodeViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }

    // presentation details
    viewModel { EpisodeDetailsViewModel(get()) }
    factory { EpisodeDetailsFragment() }

}