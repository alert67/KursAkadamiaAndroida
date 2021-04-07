package com.mateuszkukiel.kursakademiaandroida.features.character.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mateuszkukiel.kursakademiaandroida.R
import com.mateuszkukiel.kursakademiaandroida.core.base.BaseFragment
import com.mateuszkukiel.kursakademiaandroida.databinding.FragmentCharacterBinding
import com.mateuszkukiel.kursakademiaandroida.features.character.presentation.list.CharacterListAdapter
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    private var _binding: FragmentCharacterBinding? = null

    private val binding get() = _binding!!

    override val viewModel: CharacterViewModel by viewModel()

    private val characterAdapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerView.layoutManager = get<GridLayoutManager>()
        binding.recyclerView.adapter = characterAdapter
    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            characterAdapter.submitList(it.toList())
        }
    }

}