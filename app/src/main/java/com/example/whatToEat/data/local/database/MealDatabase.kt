package com.example.whatToEat.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whatToEat.data.local.dao.MealDao
import com.example.whatToEat.data.local.models.IngredientMeasurementEntityConverter
import com.example.whatToEat.data.local.models.MealEntity


@Database(
    entities = [MealEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(IngredientMeasurementEntityConverter::class)
abstract class MealDatabase: RoomDatabase() {
    abstract fun mealDao(): MealDao
}