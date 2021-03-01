package com.mateuszkukiel.kursakademiaandroida.features.character.domain

import com.mateuszkukiel.kursakademiaandroida.features.character.CharacterRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest {
    @Test
    fun `when use case is invoked than execute get characters method from repository`() {
        // given
        val repository = mockk<CharacterRepository>()
        val useCase = GetCharactersUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getCharacters() }
    }

}
