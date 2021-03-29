package com.mateuszkukiel.kursakademiaandroida.features.episode.data.repository

import com.mateuszkukiel.kursakademiaandroida.core.api.RickAndMortyApi
import com.mateuszkukiel.kursakademiaandroida.core.network.NetworkStateProvider
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.EpisodeRepository
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.EpisodeDao
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if(networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}