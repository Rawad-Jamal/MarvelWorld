package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.CreatorDTO
import com.srj.marvelworld.domain.model.Creator

class CreatorMapper: Mapper<CreatorDTO, Creator> {
    override fun mapping(input: CreatorDTO): Creator {
        return Creator(
            id = input.id?.toLong() ?: 0L,
            fullName = input.fullName ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}