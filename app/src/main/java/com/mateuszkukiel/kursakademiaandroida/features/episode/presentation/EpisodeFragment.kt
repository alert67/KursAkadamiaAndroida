package com.mateuszkukiel.kursakademiaandroida.features.episode.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.databinding.FragmentEpisodeBinding
import com.mateuszkukiel.kursakademiaandroida.databinding.VhEpisodeBinding
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.list.EpisodeListAdapter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    private var _binding: FragmentEpisodeBinding? = null

    private val binding get() = _binding!!

    override val viewModel: EpisodeViewModel by viewModel()

    private val episodeAdapter: EpisodeListAdapter by lazy {
        EpisodeListAdapter()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerView.layoutManager = get<LinearLayoutManager>()
        binding.recyclerView.adapter = episodeAdapter
    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) { list ->
            episodeAdapter.submitList(list.toMutableList())
        }
    }

}