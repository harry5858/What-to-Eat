package com.example.whatToEat.data.remote.mapper

import com.example.whatToEat.data.local.models.IngredientMeasurementEntity
import com.example.whatToEat.data.local.models.IngredientMeasurementEntityList
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
        ingredientMeasurementList = IngredientMeasurementEntityList(
            listOf(
                IngredientMeasurementEntity(ingredient = this.strIngredient1, measurement = this.strMeasure1),
                IngredientMeasurementEntity(ingredient = this.strIngredient2, measurement = this.strMeasure2),
                IngredientMeasurementEntity(ingredient = this.strIngredient3, measurement = this.strMeasure3),
                IngredientMeasurementEntity(ingredient = this.strIngredient4, measurement = this.strMeasure4),
                IngredientMeasurementEntity(ingredient = this.strIngredient5, measurement = this.strMeasure5),
                IngredientMeasurementEntity(ingredient = this.strIngredient6, measurement = this.strMeasure6),
                IngredientMeasurementEntity(ingredient = this.strIngredient7, measurement = this.strMeasure7),
                IngredientMeasurementEntity(ingredient = this.strIngredient8, measurement = this.strMeasure8),
                IngredientMeasurementEntity(ingredient = this.strIngredient9, measurement = this.strMeasure9),
                IngredientMeasurementEntity(ingredient = this.strIngredient10, measurement = this.strMeasure10),
                IngredientMeasurementEntity(ingredient = this.strIngredient11, measurement = this.strMeasure11),
                IngredientMeasurementEntity(ingredient = this.strIngredient12, measurement = this.strMeasure12),
                IngredientMeasurementEntity(ingredient = this.strIngredient13, measurement = this.strMeasure13),
                IngredientMeasurementEntity(ingredient = this.strIngredient14, measurement = this.strMeasure14),
                IngredientMeasurementEntity(ingredient = this.strIngredient15, measurement = this.strMeasure15),
                IngredientMeasurementEntity(ingredient = this.strIngredient16, measurement = this.strMeasure16),
                IngredientMeasurementEntity(ingredient = this.strIngredient17, measurement = this.strMeasure17),
                IngredientMeasurementEntity(ingredient = this.strIngredient18, measurement = this.strMeasure18),
                IngredientMeasurementEntity(ingredient = this.strIngredient19, measurement = this.strMeasure19),
                IngredientMeasurementEntity(ingredient = this.strIngredient20, measurement = this.strMeasure20),
            )
        )
    )
}