package com.mateuszkukiel.kursakademiaandroida.features.character.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mateuszkukiel.kursakademiaandroida.databinding.VhCharacterBinding
import com.mateuszkukiel.kursakademiaandroida.features.character.presentation.model.CharacterDisplayable

class CharacterViewHolder(private val binding: VhCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun inflate(parent: ViewGroup): CharacterViewHolder {
            return CharacterViewHolder(
                VhCharacterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(character: CharacterDisplayable) {
        Glide.with(binding.root).load(character.image).into(binding.characterImage)
        binding.characterName.text = character.name
    }
}