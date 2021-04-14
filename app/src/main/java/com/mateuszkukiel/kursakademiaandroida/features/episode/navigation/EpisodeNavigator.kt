package com.mateuszkukiel.kursakademiaandroida.features.episode.navigation

import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}