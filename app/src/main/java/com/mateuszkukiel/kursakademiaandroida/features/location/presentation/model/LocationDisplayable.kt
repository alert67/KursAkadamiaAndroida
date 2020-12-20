package com.mateuszkukiel.kursakademiaandroida.features.location.presentation.model

import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location

data class LocationDisplayable(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        dimension = location.dimension,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
}