package com.srj.marvelworld.domain.mapper

interface Mapper<INPUT, OUTPUT> {
    fun mapping(input: INPUT): OUTPUT
}