package com.example.whatToEat.data.local.mapper

import com.example.whatToEat.data.local.models.IngredientMeasurementEntity
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
        ingredientMeasurement1 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement1.ingredient,
            measurement = this.ingredientMeasurement1.measurement
        ),
        ingredientMeasurement2 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement2.ingredient,
            measurement = this.ingredientMeasurement2.measurement
        ),
        ingredientMeasurement3 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement3.ingredient,
            measurement = this.ingredientMeasurement3.measurement
        ),
        ingredientMeasurement4 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement4.ingredient,
            measurement = this.ingredientMeasurement4.measurement
        ),
        ingredientMeasurement5 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement5.ingredient,
            measurement = this.ingredientMeasurement5.measurement
        ),
        ingredientMeasurement6 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement6.ingredient,
            measurement = this.ingredientMeasurement6.measurement
        ),
        ingredientMeasurement7 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement7.ingredient,
            measurement = this.ingredientMeasurement7.measurement
        ),
        ingredientMeasurement8 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement8.ingredient,
            measurement = this.ingredientMeasurement8.measurement
        ),
        ingredientMeasurement9 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement9.ingredient,
            measurement = this.ingredientMeasurement9.measurement
        ),
        ingredientMeasurement10 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement10.ingredient,
            measurement = this.ingredientMeasurement10.measurement
        ),
        ingredientMeasurement11 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement11.ingredient,
            measurement = this.ingredientMeasurement11.measurement
        ),
        ingredientMeasurement12 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement12.ingredient,
            measurement = this.ingredientMeasurement12.measurement
        ),
        ingredientMeasurement13 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement13.ingredient,
            measurement = this.ingredientMeasurement13.measurement
        ),
        ingredientMeasurement14 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement14.ingredient,
            measurement = this.ingredientMeasurement14.measurement
        ),
        ingredientMeasurement15 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement15.ingredient,
            measurement = this.ingredientMeasurement15.measurement
        ),
        ingredientMeasurement16 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement16.ingredient,
            measurement = this.ingredientMeasurement16.measurement
        ),
        ingredientMeasurement17 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement17.ingredient,
            measurement = this.ingredientMeasurement17.measurement
        ),
        ingredientMeasurement18 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement18.ingredient,
            measurement = this.ingredientMeasurement18.measurement
        ),
        ingredientMeasurement19 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement19.ingredient,
            measurement = this.ingredientMeasurement19.measurement
        ),
        ingredientMeasurement20 = IngredientMeasurementEntity(
            ingredient = this.ingredientMeasurement20.ingredient,
            measurement = this.ingredientMeasurement20.measurement
        )
    )
}