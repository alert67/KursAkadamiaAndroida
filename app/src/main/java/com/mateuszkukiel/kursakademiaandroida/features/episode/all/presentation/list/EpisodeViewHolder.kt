package com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mateuszkukiel.kursakademiaandroida.databinding.VhEpisodeBinding
import com.mateuszkukiel.kursakademiaandroida.features.episode.all.presentation.model.EpisodeDisplayable

class EpisodeViewHolder(private val binding: VhEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun inflate(parent: ViewGroup): EpisodeViewHolder {
            return EpisodeViewHolder(
                VhEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun bind(episode: EpisodeDisplayable) {
        binding.episodeCodeText.text = episode.code
        binding.episodeNameText.text = episode.name
        binding.episodeAirDateText.text = episode.airDate
    }
}