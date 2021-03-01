package com.mateuszkukiel.kursakademiaandroida.features.location.domain

import com.mateuszkukiel.kursakademiaandroida.features.location.LocationRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {

    @Test
    fun `when use case is invoked than execute get locations method from repository`() {
        //given
        val repository = mockk<LocationRepository>()
        val useCase = GetLocationsUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then

        coVerify { repository.getLocations() }

    }
}