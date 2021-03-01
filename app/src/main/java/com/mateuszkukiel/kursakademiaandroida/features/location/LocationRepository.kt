package com.mateuszkukiel.kursakademiaandroida.features.location

import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}