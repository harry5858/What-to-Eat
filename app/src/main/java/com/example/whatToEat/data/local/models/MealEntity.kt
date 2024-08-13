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
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_1")
    val ingredientMeasurement1: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_2")
    val ingredientMeasurement2: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_3")
    val ingredientMeasurement3: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_4")
    val ingredientMeasurement4: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_5")
    val ingredientMeasurement5: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_6")
    val ingredientMeasurement6: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_7")
    val ingredientMeasurement7: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_8")
    val ingredientMeasurement8: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_9")
    val ingredientMeasurement9: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_10")
    val ingredientMeasurement10: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_11")
    val ingredientMeasurement11: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_12")
    val ingredientMeasurement12: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_13")
    val ingredientMeasurement13: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_14")
    val ingredientMeasurement14: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_15")
    val ingredientMeasurement15: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_16")
    val ingredientMeasurement16: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_17")
    val ingredientMeasurement17: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_18")
    val ingredientMeasurement18: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_19")
    val ingredientMeasurement19: IngredientMeasurementEntity,
    @TypeConverters(IngredientMeasurementEntityConverter::class)
    @ColumnInfo(name = "ingred_measure_20")
    val ingredientMeasurement20: IngredientMeasurementEntity,
)
