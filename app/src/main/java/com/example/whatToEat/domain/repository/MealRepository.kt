package com.example.whatToEat.domain.repository

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.util.Error
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getRandomMeal(): Flow<Result<Meal, Error>>
    suspend fun getMealById(uid: Int, apiId: Int): Flow<Result<Meal, Error>>

    suspend fun getSavedMeals(): Flow<Result<List<Meal>, Error>>
    suspend fun saveMeal(meal: Meal): Result<Nothing?, Error>
    suspend fun deleteSavedMealByUid(uid: Int): Result<Nothing?, Error>
    suspend fun deleteSavedMealByApiId(apiId: Int): Result<Nothing?, Error>
    suspend fun isMealEntryAlreadyExist(apiId: Int): Result<Boolean, Error>
}