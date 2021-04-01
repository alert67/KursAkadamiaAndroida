package com.mateuszkukiel.kursakademiaandroida.features.location.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.model.LocationDisplayable

class LocationListAdapter() :
    ListAdapter<LocationDisplayable, LocationViewHolder>(LocationDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class LocationDiffUtil : DiffUtil.ItemCallback<LocationDisplayable>() {
        override fun areItemsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem == newItem
        }

    }
}