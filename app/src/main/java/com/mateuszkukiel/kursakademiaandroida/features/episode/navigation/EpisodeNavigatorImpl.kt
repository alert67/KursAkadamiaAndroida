package com.mateuszkukiel.kursakademiaandroida.features.episode.navigation

import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.navigation.FragmentNavigator
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable
import com.mateuszkukiel.kursakademiaandroida.features.episode.details.presentation.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {
    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}