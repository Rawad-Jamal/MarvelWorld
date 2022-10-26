package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.StoryDTO
import com.srj.marvelworld.domain.model.Story

class StoryMapper: Mapper<StoryDTO, Story> {
    override fun mapping(input: StoryDTO): Story {
        return Story(
            id = input.id?.toLong()?: 0L,
            title = input.title ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}