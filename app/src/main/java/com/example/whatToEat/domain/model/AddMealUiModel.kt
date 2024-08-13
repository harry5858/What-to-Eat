package com.example.whatToEat.domain.model

import com.example.whatToEat.domain.util.Error

sealed class AddMealUiModel {
    data object Loading: AddMealUiModel()
    data object Success: AddMealUiModel()
    data class Failure(val error: Error): AddMealUiModel()
}