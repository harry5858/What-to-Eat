package com.example.whatToEat.domain.useCases

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.util.Error
import com.example.whatToEat.domain.util.validateYoutubeUrl
import javax.inject.Inject

class SaveMealUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(meal: Meal): Result<Nothing?, Error> {
        return repo.saveMeal(meal)
    }
}