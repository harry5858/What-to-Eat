package com.example.whatToEat.domain.util

fun String.validateYoutubeUrl(): Boolean {
    val regex = Regex("^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube(?:-nocookie)?\\.com|youtu.be))(\\/(?:[\\w\\-]+\\?v=|embed\\/|live\\/|v\\/)?)([\\w\\-]+)(\\S+)?\$\n")
    return regex.matches(this)
}