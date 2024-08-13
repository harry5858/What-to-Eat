package com.example.whatToEat.data.remote.mapper

import com.example.whatToEat.data.remote.models.MealResponse
import com.example.whatToEat.domain.model.IngredientMeasurement
import com.example.whatToEat.domain.model.Meal

fun MealResponse.mealResponseToMeal(): Meal {
    return Meal(
        uid = -1,
        apiId = this.idMeal,
        mealName = this.strMeal,
        category = this.strCategory,
        area = this.strArea,
        instructions = this.strInstructions,
        thumbnail = this.strMealThumb,
        youtube = this.strYoutube,
        fromDB = false,
        ingredientMeasurementList = listOf(
            IngredientMeasurement(
                ingredient = this.strIngredient1,
                measurement = this.strMeasure1
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient2,
                measurement = this.strMeasure2
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient3,
                measurement = this.strMeasure3
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient4,
                measurement = this.strMeasure4
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient5,
                measurement = this.strMeasure5
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient6,
                measurement = this.strMeasure6
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient7,
                measurement = this.strMeasure7
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient8,
                measurement = this.strMeasure8
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient9,
                measurement = this.strMeasure9
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient10,
                measurement = this.strMeasure10
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient11,
                measurement = this.strMeasure11
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient12,
                measurement = this.strMeasure12
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient13,
                measurement = this.strMeasure13
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient14,
                measurement = this.strMeasure14
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient15,
                measurement = this.strMeasure15
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient16,
                measurement = this.strMeasure16
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient17,
                measurement = this.strMeasure17
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient18,
                measurement = this.strMeasure18
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient19,
                measurement = this.strMeasure19
            ),
            IngredientMeasurement(
                ingredient = this.strIngredient20,
                measurement = this.strMeasure20
            )
        )
    )
}