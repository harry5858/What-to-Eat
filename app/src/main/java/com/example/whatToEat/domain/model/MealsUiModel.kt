package com.example.whatToEat.domain.model

import com.example.whatToEat.domain.util.Error

sealed class MealsUiModel {
    data object Loading: MealsUiModel()
    data class Success(val data: List<Meal>): MealsUiModel()
    data class Failure(val error: Error): MealsUiModel()
}