package com.mateuszkukiel.kursakademiaandroida.features.location.presentation

import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

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