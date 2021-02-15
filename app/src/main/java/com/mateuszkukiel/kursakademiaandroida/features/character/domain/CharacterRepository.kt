package com.mateuszkukiel.kursakademiaandroida.features.character.domain

import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}