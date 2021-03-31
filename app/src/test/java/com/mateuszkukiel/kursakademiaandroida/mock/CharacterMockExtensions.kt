package com.mateuszkukiel.kursakademiaandroida.mock

import com.mateuszkukiel.kursakademiaandroida.core.api.model.*
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterCached
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterLocationCached
import com.mateuszkukiel.kursakademiaandroida.features.character.data.local.model.CharacterOriginCached
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterOrigin
import org.jetbrains.annotations.TestOnly

@TestOnly
fun Character.Companion.mock() = Character(
    episodes = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    location = CharacterLocation(
        name = "character location name",
        url = "character location url"
    ),
    origin = CharacterOrigin(
        name = "character location name",
        url = "character location url"
    ),
    name = "character name",
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url",
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    episodes = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    location = CharacterLocationRemote(
        name = "character location name",
        url = "character location url"
    ),
    origin = CharacterOriginRemote(
        name = "character location name",
        url = "character location url"
    ),
    name = "character name",
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url",
    created = "character created"
)

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    episodes = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    location = CharacterLocationCached(
        name = "character location name",
        url = "character location url"
    ),
    origin = CharacterOriginCached(
        name = "character location name",
        url = "character location url"
    ),
    name = "character name",
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url",
)