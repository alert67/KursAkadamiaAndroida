package com.mateuszkukiel.kursakademiaandroida.features.location.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mateuszkukiel.kursakademiaandroida.databinding.VhLocationBinding
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.model.LocationDisplayable

class LocationViewHolder(private val binding: VhLocationBinding): RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun inflate(parent: ViewGroup): LocationViewHolder {
            return LocationViewHolder(
                VhLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun bind(location: LocationDisplayable) {
        binding.nameText.text = location.name
        binding.dimensionText.text = location.dimension
        binding.residentsText.text = location.residents.size.toString()
    }
}