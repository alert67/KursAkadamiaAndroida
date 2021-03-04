package com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterOrigin

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episodes: List<String>,
    val gender: String,
    val image: String,
    val location: CharacterLocationCached,
    val name: String,
    val origin: CharacterOriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        episodes = character.episodes,
        gender = character.gender,
        image = character.image,
        location = CharacterLocationCached(character.location),
        name = character.name,
        origin = CharacterOriginCached(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        episodes = episodes,
        gender = gender,
        image = image,
        location = location.toCharacterLocation(),
        name = name,
        origin = origin.toCharacterOrigin(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}

data class CharacterLocationCached(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}

data class CharacterOriginCached(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}
