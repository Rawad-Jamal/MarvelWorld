package com.srj.marvelworld.domain.mapper

import com.srj.marvelworld.data.remote.response.dto.EventDTO
import com.srj.marvelworld.domain.model.Event

class EventMapper: Mapper<EventDTO, Event> {
    override fun mapping(input: EventDTO): Event {
        return Event(
            id = input.id?.toLong()?: 0L,
            title = input.title ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}