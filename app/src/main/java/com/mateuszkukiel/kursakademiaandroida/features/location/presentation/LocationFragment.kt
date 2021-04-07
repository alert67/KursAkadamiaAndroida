package com.mateuszkukiel.kursakademiaandroida.features.location.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.databinding.FragmentLocationBinding
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.list.LocationListAdapter
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    private var _binding: FragmentLocationBinding? = null

    private val binding get() = _binding!!

    override val viewModel: LocationViewModel by viewModel()

    private val locationAdapter: LocationListAdapter by lazy {
        LocationListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerView.layoutManager = get<LinearLayoutManager>()
        binding.recyclerView.adapter = locationAdapter

    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) { locations ->
            locationAdapter.submitList(locations.toList())
        }
    }

}