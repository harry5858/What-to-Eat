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
        ingredientMeasurement1 = IngredientMeasurement(
            ingredient = this.strIngredient1,
            measurement = this.strMeasure1
        ),
        ingredientMeasurement2 = IngredientMeasurement(
            ingredient = this.strIngredient2,
            measurement = this.strMeasure2
        ),
        ingredientMeasurement3 = IngredientMeasurement(
            ingredient = this.strIngredient3,
            measurement = this.strMeasure3
        ),
        ingredientMeasurement4 = IngredientMeasurement(
            ingredient = this.strIngredient4,
            measurement = this.strMeasure4
        ),
        ingredientMeasurement5 = IngredientMeasurement(
            ingredient = this.strIngredient5,
            measurement = this.strMeasure5
        ),
        ingredientMeasurement6 = IngredientMeasurement(
            ingredient = this.strIngredient6,
            measurement = this.strMeasure6
        ),
        ingredientMeasurement7 = IngredientMeasurement(
            ingredient = this.strIngredient7,
            measurement = this.strMeasure7
        ),
        ingredientMeasurement8 = IngredientMeasurement(
            ingredient = this.strIngredient8,
            measurement = this.strMeasure8
        ),
        ingredientMeasurement9 = IngredientMeasurement(
            ingredient = this.strIngredient9,
            measurement = this.strMeasure9
        ),
        ingredientMeasurement10 = IngredientMeasurement(
            ingredient = this.strIngredient10,
            measurement = this.strMeasure10
        ),
        ingredientMeasurement11 = IngredientMeasurement(
            ingredient = this.strIngredient11,
            measurement = this.strMeasure11
        ),
        ingredientMeasurement12 = IngredientMeasurement(
            ingredient = this.strIngredient12,
            measurement = this.strMeasure12
        ),
        ingredientMeasurement13 = IngredientMeasurement(
            ingredient = this.strIngredient13,
            measurement = this.strMeasure13
        ),
        ingredientMeasurement14 = IngredientMeasurement(
            ingredient = this.strIngredient14,
            measurement = this.strMeasure14
        ),
        ingredientMeasurement15 = IngredientMeasurement(
            ingredient = this.strIngredient15,
            measurement = this.strMeasure15
        ),
        ingredientMeasurement16 = IngredientMeasurement(
            ingredient = this.strIngredient16,
            measurement = this.strMeasure16
        ),
        ingredientMeasurement17 = IngredientMeasurement(
            ingredient = this.strIngredient17,
            measurement = this.strMeasure17
        ),
        ingredientMeasurement18 = IngredientMeasurement(
            ingredient = this.strIngredient18,
            measurement = this.strMeasure18
        ),
        ingredientMeasurement19 = IngredientMeasurement(
            ingredient = this.strIngredient19,
            measurement = this.strMeasure19
        ),
        ingredientMeasurement20 = IngredientMeasurement(
            ingredient = this.strIngredient20,
            measurement = this.strMeasure20
        )
    )
}