package com.mateuszkukiel.kursakademiaandroida.features.episode.domain

import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}