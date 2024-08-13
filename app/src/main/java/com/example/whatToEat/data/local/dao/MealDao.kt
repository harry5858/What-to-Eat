package com.example.whatToEat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatToEat.data.local.models.MealEntity

@Dao
interface MealDao {
    @Query("SELECT * FROM savedMeal ORDER BY RANDOM() LIMIT 1")
    fun getRandomMeal(): MealEntity

    @Query("SELECT * FROM savedMeal")
    fun getAllSavedMeal(): List<MealEntity>

    @Query("SELECT * FROM savedMeal WHERE uid =:uid")
    fun getMealByUid(uid: Int): MealEntity

    @Query("SELECT * FROM savedMeal WHERE api_id = :apiId")
    fun getMealByApiId(apiId: Int): MealEntity

    @Query("SELECT COUNT(1) FROM savedMeal WHERE api_id = :apiId")
    fun checkIsMealSavedByApiId(apiId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMeal(vararg mealEntity: MealEntity)

    @Query("DELETE FROM savedMeal WHERE uid = :uid")
    fun deleteMealByUid(uid: Int)

    @Query("DELETE FROM savedMeal WHERE api_id = :apiId")
    fun deleteMealByApiId(apiId: Int)

    @Query("SELECT EXISTS(SELECT * FROM savedMeal)")
    fun isTableExist(): Boolean
}