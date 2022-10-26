package com.srj.marvelworld.ui.home

import com.srj.marvelworld.R
import com.srj.marvelworld.domain.model.*
import com.srj.marvelworld.ui.base.BaseAdapter

class CharactersAdapter(items: List<Character>, listener: HomeInteractionListener): BaseAdapter<Character>(items, listener) {
    override val layoutID: Int = R.layout.item_character
}

class ComicsAdapter(items: List<Comic>, listener: HomeInteractionListener): BaseAdapter<Comic>(items, listener) {
    override val layoutID: Int = R.layout.item_comic
}

class CreatorsAdapter(items: List<Creator>, listener: HomeInteractionListener): BaseAdapter<Creator>(items, listener) {
    override val layoutID: Int = R.layout.item_creator
}

class EventsAdapter(items: List<Event>, listener: HomeInteractionListener): BaseAdapter<Event>(items, listener) {
    override val layoutID: Int = R.layout.item_event
}

class SeriesAdapter(items: List<Series>, listener: HomeInteractionListener): BaseAdapter<Series>(items, listener) {
    override val layoutID: Int = R.layout.item_series
}

class StoriesAdapter(items: List<Story>, listener: HomeInteractionListener): BaseAdapter<Story>(items, listener) {
    override val layoutID: Int = R.layout.item_story
}