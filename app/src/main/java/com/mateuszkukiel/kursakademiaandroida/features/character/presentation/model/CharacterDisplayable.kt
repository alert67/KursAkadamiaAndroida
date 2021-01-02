package com.mateuszkukiel.kursakademiaandroida.features.character.presentation.model

import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterOrigin

data class CharacterDisplayable(
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationDisplayable,
    val name: String,
    val origin: CharacterOriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        episodes = character.episodes,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = CharacterLocationDisplayable(character.location),
        origin = CharacterOriginDisplayable(character.origin),
        name = character.name,
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}

data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}

data class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}