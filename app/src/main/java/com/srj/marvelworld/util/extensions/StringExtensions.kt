package com.srj.marvelworld.util.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.convertStringToDate(): Date = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
    .parse(this) ?: Date()