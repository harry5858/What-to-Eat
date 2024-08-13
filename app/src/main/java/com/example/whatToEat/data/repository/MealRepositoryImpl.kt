package com.example.whatToEat.data.repository

import android.database.sqlite.SQLiteException
import com.example.whatToEat.data.local.dao.MealDao
import com.example.whatToEat.data.local.mapper.mealEntityToMeal
import com.example.whatToEat.data.local.mapper.toMealEntity
import com.example.whatToEat.data.remote.MealApi
import com.example.whatToEat.data.remote.mapper.mealResponseToMeal
import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.util.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val mealDao: MealDao
): MealRepository {
    override suspend fun getRandomMeal(): Flow<Result<Meal, Error>> = flow {
        try {
            val isTableExist = mealDao.isTableExist()
            if (isTableExist) {
                val randomFlag: Int  = Math.random().toInt() % 2
                when (randomFlag) {
                    0 -> {
                        val result = mealApi.getRandomMeal()
                        if (result.code() != 200) {
                            throw Exception(result.message())
                        } else {
                            result.body()?.meals?.first()?.mealResponseToMeal()?.let { emit(Result.Success(it)) }
                        }
                    }
                    1 -> { emit(Result.Success(mealDao.getRandomMeal().mealEntityToMeal())) }
                }
            } else {
                val result = mealApi.getRandomMeal()
                if (result.code() != 200) {
                    throw Exception(result.message())
                } else {
                    result.body()?.meals?.first()?.mealResponseToMeal()?.let { emit(Result.Success(it)) }
                }
            }
        } catch (e: SQLiteException) {
            Result.Error(Error.DatabaseError)
        } catch (e: Exception) {
            Result.Error(Error.ApiError(e.message))
        }
    }

    override suspend fun getMealById(uid: Int, apiId: Int): Flow<Result<Meal, Error>> = flow {
        try {
            if (uid >= 0) {
                emit(Result.Success(mealDao.getMealByUid(uid).mealEntityToMeal()))
            } else {
                val result = mealApi.getMealById(apiId)
                val code = result.code()
                val message = result.message()
                if (code != 200) {
                    throw Exception(message)
                } else {
                    mealApi.getMealById(apiId).body()?.meals?.first()?.mealResponseToMeal()?.let { meal ->
                        if (isMealSaved(meal.apiId)) {
                            mealDao.getMealByApiId(meal.apiId).mealEntityToMeal().let { emit(Result.Success(it)) }
                        } else {
                            emit(Result.Success(meal))
                        }
                    }
                }
            }
        } catch (e: SQLiteException) {
            emit(Result.Error(Error.DatabaseError))
        } catch (e: Exception) {
            emit(Result.Error(Error.ApiError(message = e.message)))
        }
    }

    override suspend fun getSavedMeals(): Flow<Result<List<Meal>, Error>> = flow {
        try {
            val meals = mealDao.getAllSavedMeal().map{ it.mealEntityToMeal() }
            emit(Result.Success(meals))
        } catch (e: Exception) {
            emit(Result.Error(Error.DatabaseError))
        }
    }

    override suspend fun saveMeal(meal: Meal): Result<Nothing?, Error> {
        return try {
            println("--------------------------- repo: $meal")
            mealDao.saveMeal(meal.toMealEntity())
            Result.Success(null)
        } catch (e: Exception) {
            Result.Error(Error.DatabaseError)
        }
    }

    override suspend fun deleteSavedMealByUid(uid: Int): Result<Nothing?, Error> {
        return try {
            mealDao.deleteMealByUid(uid)
            Result.Success(null)
        } catch (e: Exception) {
            Result.Error(Error.DatabaseError)
        }

    }

    override suspend fun deleteSavedMealByApiId(apiId: Int): Result<Nothing?, Error> {
        return try {
            mealDao.deleteMealByApiId(apiId)
            Result.Success(null)
        } catch (e: Exception) {
            Result.Error(Error.DatabaseError)
        }
    }

    override suspend fun isMealEntryAlreadyExist(apiId: Int): Result<Boolean, Error> {
        return try {
            val isExist = isMealSaved(apiId)
            Result.Success(isExist)
        } catch (e: Exception) {
            Result.Error(Error.DatabaseError)
        }
    }

    private fun isMealSaved(apiId: Int): Boolean {
        return mealDao.checkIsMealSavedByApiId(apiId)
    }
}