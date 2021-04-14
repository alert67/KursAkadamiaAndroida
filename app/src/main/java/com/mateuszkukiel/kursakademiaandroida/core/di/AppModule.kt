package com.mateuszkukiel.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.FragmentActivity
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.exception.ErrorMapper
import com.mateuszkukiel.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.mateuszkukiel.kursakademiaandroida.core.exception.ErrorWrapper
import com.mateuszkukiel.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.mateuszkukiel.kursakademiaandroida.core.navigation.FragmentNavigator
import com.mateuszkukiel.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import com.mateuszkukiel.kursakademiaandroida.core.network.NetworkStateProvider
import com.mateuszkukiel.kursakademiaandroida.core.network.NetworkStateProviderImpl
import com.mateuszkukiel.kursakademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), 2, GridLayoutManager.VERTICAL, false) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.episode_screen,
            defaultNavOption = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}