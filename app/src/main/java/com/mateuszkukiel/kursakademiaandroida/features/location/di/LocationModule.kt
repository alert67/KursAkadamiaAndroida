package com.mateuszkukiel.kursakademiaandroida.features.location.di

import com.mateuszkukiel.kursakademiaandroida.features.location.data.repository.LocationRepositoryImpl
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.GetLocationsUseCase
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.LocationRepository
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.LocationFragment
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get())  }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
}