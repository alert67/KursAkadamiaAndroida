package com.mateuszkukiel.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mateuszkukiel.kursakademiaandroida.features.character.presentation.CharacterFragment
import com.mateuszkukiel.kursakademiaandroida.features.episode.presentation.EpisodeFragment
import com.mateuszkukiel.kursakademiaandroida.features.location.presentation.LocationFragment

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> EpisodeFragment()
                    1 -> LocationFragment()
                    2 -> CharacterFragment()
                    else -> EpisodeFragment()
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ViewPager2>(R.id.pager).adapter = adapter
    }
}