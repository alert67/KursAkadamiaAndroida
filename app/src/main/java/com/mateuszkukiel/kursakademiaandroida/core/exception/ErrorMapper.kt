package com.mateuszkukiel.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}