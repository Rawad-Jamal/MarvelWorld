package com.srj.marvelworld.domain.model

import java.util.*

data class CharacterDetails(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val modified: Date,
)