package com.mateuszkukiel.kursakademiaandroida.features.character.presentation

import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initObservers() {
        super.initObservers()
    }

    override fun initViews() {
        super.initViews()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

}