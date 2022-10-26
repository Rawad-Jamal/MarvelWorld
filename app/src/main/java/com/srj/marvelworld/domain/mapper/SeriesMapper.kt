package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.SeriesDTO
import com.srj.marvelworld.domain.model.Series

class SeriesMapper: Mapper<SeriesDTO, Series> {
    override fun mapping(input: SeriesDTO): Series {
        return Series(
            id = input.id?.toLong()?: 0L,
            title = input.title ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}