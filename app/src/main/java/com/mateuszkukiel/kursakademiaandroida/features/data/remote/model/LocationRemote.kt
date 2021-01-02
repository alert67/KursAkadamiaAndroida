package com.mateuszkukiel.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.mateuszkukiel.kursakademiaandroida.features.location.domain.model.Location

data class LocationRemote(
    @SerializedName("created") val created: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toLocation() = Location(
        id = id,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}