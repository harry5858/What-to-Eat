package com.example.whatToEat.ui.util

import android.content.Context
import com.example.whatToEat.R
import com.example.whatToEat.domain.util.Error

fun Error.toErrorString(context: Context?): String {
    return when (this) {
        Error.AddMealError.EmptyInstructionError -> context?.getString(R.string.add_meal_instruction_empty_error_message)
        Error.AddMealError.EmptyMealNameError -> context?.getString(R.string.add_meal_meal_name_empty_error_message)
        Error.AddMealError.InvalidYoutubeUrlError -> context?.getString(R.string.add_meal_invalid_youtube_url_error_message)
        Error.AddMealError.MaximumIngredientError -> context?.getString(R.string.add_meal_maximum_ingredient_error_message)
        is Error.ApiError -> context?.getString(R.string.api_error, this.message)
        Error.DatabaseError -> context?.getString(R.string.database_error)
        Error.UnknownError -> context?.getString(R.string.unknown_error)
    } ?: "Unknown Error"
}