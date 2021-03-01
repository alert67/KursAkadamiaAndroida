package com.mateuszkukiel.kursakademiaandroida.features.location.domain

import com.mateuszkukiel.kursakademiaandroida.core.base.UseCase
import com.mateuszkukiel.kursakademiaandroida.features.location.LocationRepository
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}