package com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseViewModel
import com.mateuszkukiel.kursakademiaandroida.core.exception.ErrorMapper
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.GetEpisodesUseCase
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable
import com.mateuszkukiel.kursakademiaandroida.features.episode.navigation.EpisodeNavigator

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val episodeNavigator: EpisodeNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(episode: EpisodeDisplayable) {
        episodeNavigator.openEpisodeDetailsScreen(episode)
    }
}