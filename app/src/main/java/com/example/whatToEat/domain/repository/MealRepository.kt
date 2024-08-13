package com.example.whatToEat.domain.repository

import com.example.whatToEat.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getRandomMeal(): Flow<Meal>
    suspend fun getMealById(uid: Int, apiId: Int): Flow<Meal>

    suspend fun getSavedMeals(): Flow<List<Meal>>
    suspend fun saveMeal(meal: Meal)
    suspend fun deleteSavedMealByUid(uid: Int)
    suspend fun deleteSavedMealByApiId(apiId: Int)
}