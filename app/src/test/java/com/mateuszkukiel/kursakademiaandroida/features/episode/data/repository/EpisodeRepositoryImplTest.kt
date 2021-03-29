package com.mateuszkukiel.kursakademiaandroida.features.episode.data.repository

import com.mateuszkukiel.kursakademiaandroida.core.api.RickAndMortyApi
import com.mateuszkukiel.kursakademiaandroida.core.api.model.EpisodeResponse
import com.mateuszkukiel.kursakademiaandroida.core.network.NetworkStateProvider
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.EpisodeRepository
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.EpisodeDao
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import com.mateuszkukiel.kursakademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodeResponse.mock()
        }
        val episodesDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodesDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodeResponse.mock()
        }
        val episodesDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodesDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodesDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        //given
        val api = mockk<RickAndMortyApi> (relaxed = true)
        val episodesDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodesDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodesDao.getEpisodes() }
    }

}