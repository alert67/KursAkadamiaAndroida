package com.mateuszkukiel.kursakademiaandroida.features.location.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.mateuszkukiel.kursakademiaandroida.core.base.UiState
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.GetLocationsUseCase
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location
import com.mateuszkukiel.kursakademiaandroida.mock.mock
import com.mateuszkukiel.kursakademiaandroida.utils.ViewModelTest
import com.mateuszkukiel.kursakademiaandroida.utils.getOrAwaitValue
import com.mateuszkukiel.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

class LocationViewModelTest: ViewModelTest() {
    @Test
    fun`WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case results is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.type shouldBe location.type
            locationDisplayable.id shouldBe location.id
        }
    }

    @Test
    fun `GIVEN use case results is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}