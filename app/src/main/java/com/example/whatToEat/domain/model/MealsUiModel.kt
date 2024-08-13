package com.example.whatToEat.domain.model

sealed class MealsUiModel {
    data object Loading: MealsUiModel()
    data class Success(val data: List<Meal>): MealsUiModel()
    data class Error(val error: String): MealsUiModel()
}