package com.mateuszkukiel.kursakademiaandroida.mock

import com.mateuszkukiel.kursakademiaandroida.features.location.data.local.model.LocationCached
import com.mateuszkukiel.kursakademiaandroida.core.api.model.*
import org.jetbrains.annotations.TestOnly

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "location type",
    url = "location url",
    created = "location created",
    dimension = "location dimension",
    residents = emptyList()
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    url = "location url",
    dimension = "location dimension",
    residents = emptyList()
)