package com.srj.marvelworld.ui.home

import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseInteractionListener

interface HomeInteractionListener: BaseInteractionListener {
    fun onItemClick(itemId: Int, itemType: MarvelContentType)
}