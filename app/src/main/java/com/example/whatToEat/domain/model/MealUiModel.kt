package com.example.whatToEat.domain.model

sealed class MealUiModel {
    data object Loading: MealUiModel()
    data class Success(val data: Meal): MealUiModel()
    data class Error(val error: String): MealUiModel()
}