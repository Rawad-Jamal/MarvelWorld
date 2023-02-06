package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.CharacterDTO
import com.srj.marvelworld.domain.model.Character

class CharacterMapper: Mapper<CharacterDTO, Character> {
    override fun mapping(input: CharacterDTO): Character {
        return Character(
            id = input.id ?: 0,
            name = input.name ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}