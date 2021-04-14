package com.mateuszkukiel.kursakademiaandroida.features.episode.navigation

import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.navigation.FragmentNavigator
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable
import com.mateuszkukiel.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeNavigatorImplTest {

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and episode model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        //when
        episodeNavigator.openEpisodeDetailsScreen(episode)

        //than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_episodes_screen_to_episode_details_screen, capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator `() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        //when
        episodeNavigator.goBack()

        //than
        verify {
            fragmentNavigator.goBack()
        }
    }
}