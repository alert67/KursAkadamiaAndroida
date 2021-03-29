package com.mateuszkukiel.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import com.mateuszkukiel.kursakademiaandroida.core.api.model.ResponseInfo
import com.mateuszkukiel.kursakademiaandroida.core.api.model.LocationRemote

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}