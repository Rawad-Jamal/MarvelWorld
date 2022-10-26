package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.ComicDTO
import com.srj.marvelworld.domain.model.Comic

class ComicMapper: Mapper<ComicDTO, Comic> {
    override fun mapping(input: ComicDTO): Comic {
        return Comic(
            id = input.id?.toLong()?: 0L,
            title = input.title ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}