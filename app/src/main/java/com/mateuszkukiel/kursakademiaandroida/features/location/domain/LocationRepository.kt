package com.mateuszkukiel.kursakademiaandroida.features.location.domain

import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}