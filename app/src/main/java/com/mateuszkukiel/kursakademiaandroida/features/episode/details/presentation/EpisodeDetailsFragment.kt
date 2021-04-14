package com.mateuszkukiel.kursakademiaandroida.features.episode.details.presentation

import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode_details) {
    override val viewModel: EpisodeViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}