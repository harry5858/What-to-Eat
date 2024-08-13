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
    val ingredientMeasurement1: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement2: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement3: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement4: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement5: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement6: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement7: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement8: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement9: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement10: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement11: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement12: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement13: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement14: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement15: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement16: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement17: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement18: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement19: IngredientMeasurement = IngredientMeasurement(),
    val ingredientMeasurement20: IngredientMeasurement = IngredientMeasurement(),
) {
    val ingredientMeasurementList: List<IngredientMeasurement> = listOf(
        ingredientMeasurement1, ingredientMeasurement2,
        ingredientMeasurement3, ingredientMeasurement4,
        ingredientMeasurement5, ingredientMeasurement6,
        ingredientMeasurement7, ingredientMeasurement8,
        ingredientMeasurement9, ingredientMeasurement10,
        ingredientMeasurement11, ingredientMeasurement12,
        ingredientMeasurement13, ingredientMeasurement14,
        ingredientMeasurement15, ingredientMeasurement16,
        ingredientMeasurement17, ingredientMeasurement18,
        ingredientMeasurement19, ingredientMeasurement20,
    )
}

//fun Meal.inputIngredientMeasurementList(list: List<Pair<String, String>>): Meal {
//    list.forEachIndexed { index, (ingredient, measurement) ->
//        this.copy(
//            in
//        )
//    }
//}
