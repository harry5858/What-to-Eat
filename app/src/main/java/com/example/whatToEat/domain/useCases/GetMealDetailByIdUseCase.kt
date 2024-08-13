package com.example.whatToEat.domain.useCases

import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealDetailByIdUseCase @Inject constructor(
    private val repo: MealRepository
){
    suspend fun invoke(uid: Int, apiId: Int): Flow<Meal> = repo.getMealById(uid, apiId)
}