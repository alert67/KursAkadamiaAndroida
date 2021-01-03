package com.mateuszkukiel.kursakademiaandroida.features.episode.domain

import com.mateuszkukiel.kursakademiaandroida.core.base.UseCase
import com.mateuszkukiel.kursakademiaandroida.features.episode.EpisodeRepository
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}