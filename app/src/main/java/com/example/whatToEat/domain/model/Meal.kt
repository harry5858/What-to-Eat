package com.example.whatToEat.domain.model

data class Meal(
    val uid: Int = -1,
    val apiId: Int = -1,
    val mealName: String = "",
    val category: String = "",
    val area: String = "",
    val instructions: String = "",
    val thumbnail: String? = null,
    val youtube: String? = null,
    val fromDB: Boolean = true,
    val ingredientMeasurementList: List<IngredientMeasurement> = listOf(),
) {
}

fun Meal.inputIngredientMeasurementList(list: List<Pair<String, String>>): Meal {
    return this.copy(ingredientMeasurementList = list.map {(ingredient, measurement) ->
        IngredientMeasurement(ingredient, measurement)
    })
}
