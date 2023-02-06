package com.srj.marvelworld.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.srj.marvelworld.R
import com.srj.marvelworld.data.remote.request.UiState
import com.srj.marvelworld.databinding.FragmentHomeBinding
import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseFragment
import com.srj.marvelworld.util.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModelClass = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        handleMarvelContentType()
        handleEvents()
    }

    private fun handleMarvelContentType(){
        viewModel.currentType.observe(viewLifecycleOwner) {
            when (it) {
                MarvelContentType.CHARACTERS -> handleCharactersAdapterItems()
                MarvelContentType.COMICS -> handleComicsAdapterItems()
                MarvelContentType.CREATORS -> handleCreatorsAdapterItems()
                MarvelContentType.EVENTS -> handleEventsAdapterItems()
                MarvelContentType.SERIES -> handleSeriesAdapterItems()
                MarvelContentType.STORIES -> handleStoriesAdapterItems()
                else -> handleCharactersAdapterItems()
            }
        }
    }


    private fun <LT> handleUiStateItems(state: UiState<List<LT>>): List<LT> {
        return if (state is UiState.Success) state.responseData else emptyList()
    }

    private fun handleCharactersAdapterItems(){
        viewModel.listCharacters.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = CharactersAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleComicsAdapterItems(){
        viewModel.listComics.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = ComicsAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleCreatorsAdapterItems(){
        viewModel.listCreators.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = CreatorsAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleEventsAdapterItems(){
        viewModel.listEvents.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = EventsAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleSeriesAdapterItems(){
        viewModel.listSeries.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = SeriesAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleStoriesAdapterItems(){
        viewModel.listStories.observe(viewLifecycleOwner) { state ->
            binding.recyclerMarvelData.adapter = StoriesAdapter(handleUiStateItems(state), viewModel)
        }
    }

    private fun handleEvents(){
        viewModel.navigateToCharacterDetails.observeEvent(viewLifecycleOwner){ characterId ->
            navigateToCharacterDetails(characterId)
        }
    }

    private fun navigateToCharacterDetails(characterId: Int){
        requireView().findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(characterId))
    }

}