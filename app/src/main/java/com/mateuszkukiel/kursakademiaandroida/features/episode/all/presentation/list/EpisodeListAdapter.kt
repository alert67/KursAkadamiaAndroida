package com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable

class EpisodeListAdapter(
    val onItemClick: (EpisodeDisplayable) -> Unit
): ListAdapter<EpisodeDisplayable, EpisodeViewHolder>(EpisodeDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { episode ->
            holder.bind(episode)
            holder.itemView.setOnClickListener {
                onItemClick(episode)
            }
        }
    }

    class EpisodeDiffUtil: DiffUtil.ItemCallback<EpisodeDisplayable>() {
        override fun areItemsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem == newItem
        }

    }
}