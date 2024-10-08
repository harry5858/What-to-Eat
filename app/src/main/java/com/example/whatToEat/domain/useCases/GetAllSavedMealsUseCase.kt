package com.example.whatToEat.domain.useCases

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.util.Error
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSavedMealsUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(): Flow<Result<List<Meal>, Error>> {
        return repo.getSavedMeals()
    }
}