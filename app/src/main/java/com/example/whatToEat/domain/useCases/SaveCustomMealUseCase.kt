package com.example.whatToEat.domain.useCases

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.util.Error
import com.example.whatToEat.domain.util.validateYoutubeUrl
import javax.inject.Inject

class SaveCustomMealUseCase @Inject constructor(
    private val repo: MealRepository
){
    suspend fun invoke(meal: Meal): Result<Nothing?, Error> {
        println("--------- mealName --- ${meal.mealName.isBlank()}")
        println("--------- instructions --- ${meal.instructions.isBlank()}")
        println("--------- youtube --- ${meal.youtube?.validateYoutubeUrl()}")
        if (meal.mealName.isBlank()) return  Result.Error(Error.AddMealError.EmptyMealNameError)
        if (meal.instructions.isBlank()) return Result.Error(Error.AddMealError.EmptyInstructionError)
        if (meal.youtube?.validateYoutubeUrl() != null) return Result.Error(Error.AddMealError.InvalidYoutubeUrlError)
        return repo.saveMeal(meal)
    }

}