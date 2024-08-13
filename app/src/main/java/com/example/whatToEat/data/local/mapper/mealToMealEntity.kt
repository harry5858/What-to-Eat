package com.example.whatToEat.data.local.mapper

import com.example.whatToEat.data.local.models.IngredientMeasurementEntity
import com.example.whatToEat.data.local.models.IngredientMeasurementEntityList
import com.example.whatToEat.data.local.models.MealEntity
import com.example.whatToEat.domain.model.Meal


fun Meal.toMealEntity(): MealEntity {
    return MealEntity(
        apiId = this.apiId,
        mealName = this.mealName,
        category = this.category,
        area = this.area,
        instructions = this.instructions,
        thumbnail = this.thumbnail,
        youtube = this.youtube,
        ingredientMeasurementList = IngredientMeasurementEntityList(
            ingredientMeasurementList.map {
                IngredientMeasurementEntity(it.ingredient, it.measurement)
            }
        )
    )
}