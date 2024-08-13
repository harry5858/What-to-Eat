package com.example.whatToEat.domain.util


sealed class Error {
    data class ApiError(val message: String?): Error()
    data object UnknownError: Error()
    data object DatabaseError: Error()
    sealed class AddMealError: Error() {
        data object EmptyMealNameError: AddMealError()
        data object EmptyInstructionError: AddMealError()
        data object InvalidYoutubeUrlError: AddMealError()
        data object MaximumIngredientError: AddMealError()
    }
}