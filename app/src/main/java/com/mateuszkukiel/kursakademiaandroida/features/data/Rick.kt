package com.mateuszkukiel.kursakademiaandroida.features.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rick(
    @PrimaryKey val uid: Int
)
