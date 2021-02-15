package com.mateuszkukiel.kursakademiaandroida.features.character.domain

import com.mateuszkukiel.kursakademiaandroida.core.base.UseCase
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}