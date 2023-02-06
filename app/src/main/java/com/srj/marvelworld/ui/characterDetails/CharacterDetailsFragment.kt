package com.srj.marvelworld.ui.characterDetails

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayout
import com.srj.marvelworld.R
import com.srj.marvelworld.data.remote.request.UiState
import com.srj.marvelworld.databinding.FragmentCharacterDetailsBinding
import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseFragment
import com.srj.marvelworld.ui.home.ComicsAdapter
import com.srj.marvelworld.ui.home.EventsAdapter
import com.srj.marvelworld.ui.home.SeriesAdapter
import com.srj.marvelworld.ui.home.StoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment: BaseFragment<FragmentCharacterDetailsBinding,
        CharacterDetailsViewModel>(R.layout.fragment_character_details),
    TabLayout.OnTabSelectedListener {
    override val viewModelClass = CharacterDetailsViewModel::class.java
    override var bottomNavigationViewVisibility = View.GONE

    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        args.characterId.let { viewModel.getCharacterData(it) }

        handleTabLayout()
        handleMarvelContentType()
    }

    private fun handleMarvelContentType(){
        viewModel.currentType.observe(viewLifecycleOwner) {
            when (it) {
                MarvelContentType.COMICS -> handleComicsAdapterItems()
                MarvelContentType.EVENTS -> handleEventsAdapterItems()
                MarvelContentType.SERIES -> handleSeriesAdapterItems()
                MarvelContentType.STORIES -> handleStoriesAdapterItems()
                else -> handleComicsAdapterItems()
            }
        }
    }

    private fun <LT> handleUiStateItems(state: UiState<List<LT>>): List<LT> {
        return if (state is UiState.Success) state.responseData else emptyList()
    }

    private fun handleComicsAdapterItems(){
        viewModel.listComics.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelCharacterData.adapter = ComicsAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleEventsAdapterItems(){
        viewModel.listEvents.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelCharacterData.adapter = EventsAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleSeriesAdapterItems(){
        viewModel.listSeries.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelCharacterData.adapter = SeriesAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleStoriesAdapterItems(){
        viewModel.listStories.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelCharacterData.adapter = StoriesAdapter(handleUiStateItems(state), viewModel)
        }
    }


    private fun handleTabLayout() {
        binding.tabLayoutContainer.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> {
                viewModel.onTabLayoutClick(MarvelContentType.COMICS)
            }
            1 -> {
                viewModel.onTabLayoutClick(MarvelContentType.STORIES)
            }
            2 -> {
                viewModel.onTabLayoutClick(MarvelContentType.EVENTS)
            }
            3 -> {
                viewModel.onTabLayoutClick(MarvelContentType.SERIES)
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) { }

    override fun onTabReselected(tab: TabLayout.Tab?) { }

}