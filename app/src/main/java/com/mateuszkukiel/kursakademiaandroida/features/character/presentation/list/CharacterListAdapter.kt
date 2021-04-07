package com.mateuszkukiel.kursakademiaandroida.features.character.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mateuszkukiel.kursakademiaandroida.features.character.presentation.model.CharacterDisplayable

class CharacterListAdapter(): ListAdapter<CharacterDisplayable, CharacterViewHolder>(CharacterDiff()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class CharacterDiff: DiffUtil.ItemCallback<CharacterDisplayable>() {
        override fun areItemsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem == newItem
        }
    }
}