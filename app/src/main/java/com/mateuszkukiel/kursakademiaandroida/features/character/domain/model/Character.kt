package com.mateuszkukiel.kursakademiaandroida.features.character.domain.model

class Character(
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    companion object
}

class CharacterLocation(
    val name: String,
    val url: String
)

class CharacterOrigin(
    val name: String,
    val url: String
)