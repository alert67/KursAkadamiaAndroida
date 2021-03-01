package com.mateuszkukiel.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.Character
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.mateuszkukiel.kursakademiaandroida.features.character.domain.model.CharacterOrigin

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episodes: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: CharacterOriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        episodes = this.episodes,
        gender = this.gender,
        id = this.id,
        image = this.image,
        location = this.location.toCharacterLocation(),
        origin = this.origin.toCharacterOrigin(),
        name = this.name,
        species = this.species,
        status = this.status,
        type = this.type,
        url = this.url
    )
}

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() = CharacterLocation(
        name = this.name,
        url = this.url
    )
}

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterOrigin() = CharacterOrigin(
        name = this.name,
        url = this.url
    )
}