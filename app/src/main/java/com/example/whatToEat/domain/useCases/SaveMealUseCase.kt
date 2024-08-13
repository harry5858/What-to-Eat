package com.example.whatToEat.domain.useCases

import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import javax.inject.Inject

class SaveMealUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(meal: Meal) {
        repo.saveMeal(meal)
    }
}