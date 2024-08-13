package com.example.whatToEat.data.remote.mapper

import com.example.whatToEat.data.local.models.IngredientMeasurementEntity
import com.example.whatToEat.data.local.models.MealEntity
import com.example.whatToEat.data.remote.models.MealResponse

fun MealResponse.mealResponseToMealEntity(): MealEntity {
    return MealEntity(
        uid = this.idMeal,
        apiId = this.idMeal,
        mealName = this.strMeal,
        category = this.strCategory,
        area = this.strArea,
        instructions = this.strInstructions,
        thumbnail = this.strMealThumb,
        youtube = this.strYoutube,
        ingredientMeasurement1 = IngredientMeasurementEntity(
            ingredient = this.strIngredient1,
            measurement = this.strMeasure1
        ),
        ingredientMeasurement2 = IngredientMeasurementEntity(
            ingredient = this.strIngredient2,
            measurement = this.strMeasure2
        ),
        ingredientMeasurement3 = IngredientMeasurementEntity(
            ingredient = this.strIngredient3,
            measurement = this.strMeasure3
        ),
        ingredientMeasurement4 = IngredientMeasurementEntity(
            ingredient = this.strIngredient4,
            measurement = this.strMeasure4
        ),
        ingredientMeasurement5 = IngredientMeasurementEntity(
            ingredient = this.strIngredient5,
            measurement = this.strMeasure5
        ),
        ingredientMeasurement6 = IngredientMeasurementEntity(
            ingredient = this.strIngredient6,
            measurement = this.strMeasure6
        ),
        ingredientMeasurement7 = IngredientMeasurementEntity(
            ingredient = this.strIngredient7,
            measurement = this.strMeasure7
        ),
        ingredientMeasurement8 = IngredientMeasurementEntity(
            ingredient = this.strIngredient8,
            measurement = this.strMeasure8
        ),
        ingredientMeasurement9 = IngredientMeasurementEntity(
            ingredient = this.strIngredient9,
            measurement = this.strMeasure9
        ),
        ingredientMeasurement10 = IngredientMeasurementEntity(
            ingredient = this.strIngredient10,
            measurement = this.strMeasure10
        ),
        ingredientMeasurement11 = IngredientMeasurementEntity(
            ingredient = this.strIngredient11,
            measurement = this.strMeasure11
        ),
        ingredientMeasurement12 = IngredientMeasurementEntity(
            ingredient = this.strIngredient12,
            measurement = this.strMeasure12
        ),
        ingredientMeasurement13 = IngredientMeasurementEntity(
            ingredient = this.strIngredient13,
            measurement = this.strMeasure13
        ),
        ingredientMeasurement14 = IngredientMeasurementEntity(
            ingredient = this.strIngredient14,
            measurement = this.strMeasure14
        ),
        ingredientMeasurement15 = IngredientMeasurementEntity(
            ingredient = this.strIngredient15,
            measurement = this.strMeasure15
        ),
        ingredientMeasurement16 = IngredientMeasurementEntity(
            ingredient = this.strIngredient16,
            measurement = this.strMeasure16
        ),
        ingredientMeasurement17 = IngredientMeasurementEntity(
            ingredient = this.strIngredient17,
            measurement = this.strMeasure17
        ),
        ingredientMeasurement18 = IngredientMeasurementEntity(
            ingredient = this.strIngredient18,
            measurement = this.strMeasure18
        ),
        ingredientMeasurement19 = IngredientMeasurementEntity(
            ingredient = this.strIngredient19,
            measurement = this.strMeasure19
        ),
        ingredientMeasurement20 = IngredientMeasurementEntity(
            ingredient = this.strIngredient20,
            measurement = this.strMeasure20
        )
    )
}