package com.example.whatToEat.utils

fun validateYoutubeUrl(url: String): Boolean {
    val regex = Regex("^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube(?:-nocookie)?\\.com|youtu.be))(\\/(?:[\\w\\-]+\\?v=|embed\\/|live\\/|v\\/)?)([\\w\\-]+)(\\S+)?\$\n")
    return regex.matches(url)
}