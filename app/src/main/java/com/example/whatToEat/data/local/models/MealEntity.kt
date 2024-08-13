package com.example.whatToEat.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "savedMeal")
data class MealEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "api_id") val apiId: Int = -1,
    @ColumnInfo(name = "meal_name") val mealName: String,
    val category: String,
    val area: String,
    val instructions: String,
    val thumbnail: String? = null,
    val youtube: String? = null,
    @TypeConverters(IngredientMeasurementEntityListConverter::class)
    @ColumnInfo(name = "ingredient_measurement_list")
    val ingredientMeasurementList: IngredientMeasurementEntityList
)
