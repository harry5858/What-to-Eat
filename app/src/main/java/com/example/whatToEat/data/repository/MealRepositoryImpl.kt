package com.example.whatToEat.data.repository

import com.example.whatToEat.data.local.dao.MealDao
import com.example.whatToEat.data.local.mapper.mealEntityToMeal
import com.example.whatToEat.data.local.mapper.toMealEntity
import com.example.whatToEat.data.remote.MealApi
import com.example.whatToEat.data.remote.mapper.mealResponseToMeal
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val mealDao: MealDao
): MealRepository {
    override suspend fun getRandomMeal(): Flow<Meal> = flow {
        val isTableExist = mealDao.isTableExist()
        if (isTableExist) {
            val randomFlag: Int  = Math.random().toInt() % 2
            when (randomFlag) {
                0 -> { mealApi.getRandomMeal().body()?.meals?.first()?.mealResponseToMeal()?.let { emit(it) } }
                1 -> { emit(mealDao.getRandomMeal().mealEntityToMeal()) }
            }
        } else {
            mealApi.getRandomMeal().body()?.meals?.first()?.mealResponseToMeal()?.let { emit(it) }
        }
    }

    override suspend fun getMealById(uid: Int, apiId: Int): Flow<Meal> = flow {
        if (uid >= 0) {
            emit(mealDao.getMealByUid(uid).mealEntityToMeal())
        } else {
            mealApi.getMealById(apiId).body()?.meals?.first()?.mealResponseToMeal()?.let { meal ->
                if (isMealSaved(meal)) {
                    mealDao.getMealByApiId(meal.apiId).mealEntityToMeal().let { emit(it) }
                } else {
                    emit(meal)
                }
            }
        }
    }

    override suspend fun getSavedMeals(): Flow<List<Meal>> = flow {
        emit(mealDao.getAllSavedMeal().map{ it.mealEntityToMeal() })
    }

    override suspend fun saveMeal(meal: Meal) {
        mealDao.saveMeal(meal.toMealEntity())
    }

    override suspend fun deleteSavedMealByUid(uid: Int) {
        mealDao.deleteMealByUid(uid)
    }

    override suspend fun deleteSavedMealByApiId(apiId: Int) {
        mealDao.deleteMealByApiId(apiId)
    }

    private fun isMealSaved(meal: Meal): Boolean {
        return mealDao.checkIsMealSavedByApiId(meal.apiId)
    }
}