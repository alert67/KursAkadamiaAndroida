package com.mateuszkukiel.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.mateuszkukiel.kursakademiaandroida.features.episode.domain.model.Episode

data class EpisodeRemote(
    @SerializedName("air_date") val airDate: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("created") val created: String,
    @SerializedName("episode") val code: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}
