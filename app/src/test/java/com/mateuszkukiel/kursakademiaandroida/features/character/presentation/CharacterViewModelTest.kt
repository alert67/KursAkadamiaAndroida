package com.mateuszkukiel.kursakademiaandroida.features.character.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.mateuszkukiel.kursakademiaandroida.core.base.UiState
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.GetCharactersUseCase
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character
import com.mateuszkukiel.kursakademiaandroida.mock.mock
import com.mateuszkukiel.kursakademiaandroida.utils.ViewModelTest
import com.mateuszkukiel.kursakademiaandroida.utils.getOrAwaitValue
import com.mateuszkukiel.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case results is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }

        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.gender shouldBe character.gender
            characterDisplayable.location.name shouldBe character.location.name
            characterDisplayable.status shouldBe character.status
            characterDisplayable.origin.name shouldBe character.origin.name
        }
    }

    @Test
    fun `GIVEN use case results is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}