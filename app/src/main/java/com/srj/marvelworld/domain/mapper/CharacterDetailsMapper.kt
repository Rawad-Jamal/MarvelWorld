package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.CharacterDTO
import com.srj.marvelworld.domain.model.CharacterDetails
import com.srj.marvelworld.util.extensions.convertStringToDate
import java.util.*

class CharacterDetailsMapper: Mapper<CharacterDTO, CharacterDetails> {
    override fun mapping(input: CharacterDTO): CharacterDetails {
        return CharacterDetails(
            id = input.id ?: 0,
            name = input.name ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description ?: "",
            modified = input.modified?.convertStringToDate() ?: Date(),
        )
    }
}