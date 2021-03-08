package com.mateuszkukiel.kursakademiaandroida.mock

import com.mateuszkukiel.kursakademiaandroida.core.api.model.EpisodeRemote
import com.mateuszkukiel.kursakademiaandroida.core.api.model.EpisodeResponse
import com.mateuszkukiel.kursakademiaandroida.core.api.model.ResponseInfo
import com.mateuszkukiel.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode
import org.jetbrains.annotations.TestOnly
import org.junit.jupiter.api.Test

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "Episode name",
    airDate = "Episode air date",
    code = "Episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "Episode name",
    airDate = "Episode air date",
    code = "Episode code",
    characters = emptyList(),
    url = "episode url",
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "Episode name",
    airDate = "Episode air date",
    code = "Episode code",
    characters = emptyList(),
    url = "episode url"
)
