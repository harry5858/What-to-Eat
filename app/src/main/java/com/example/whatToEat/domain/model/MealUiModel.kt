package com.example.whatToEat.domain.model

import com.example.whatToEat.domain.util.Error

sealed class MealUiModel {
    data object Loading: MealUiModel()
    data class Success(val data: Meal): MealUiModel()
    data class Failure(val error: Error): MealUiModel()
}