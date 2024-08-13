package com.example.whatToEat.domain.useCases

import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(): Flow<Meal> = repo.getRandomMeal()
}