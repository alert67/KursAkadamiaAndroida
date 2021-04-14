package com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model

import android.os.Parcelable
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeDisplayable(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
) : Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    companion object
}