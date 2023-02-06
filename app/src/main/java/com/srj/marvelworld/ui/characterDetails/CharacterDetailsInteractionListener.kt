package com.srj.marvelworld.ui.characterDetails

import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseInteractionListener

interface CharacterDetailsInteractionListener:BaseInteractionListener {
    fun onItemClick(itemId: Int, itemType: MarvelContentType)
}