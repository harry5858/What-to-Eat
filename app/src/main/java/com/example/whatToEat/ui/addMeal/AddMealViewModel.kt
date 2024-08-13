package com.example.whatToEat.ui.addMeal

import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.useCases.SaveMealUseCase
import com.example.whatToEat.ui.base.BaseViewModel
import com.example.whatToEat.utils.validateYoutubeUrl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AddMealViewModel @Inject constructor(
    private val saveMealUseCase: SaveMealUseCase
): BaseViewModel() {

    companion object {
        const val MAX_INGREDIENT_COUNT = 4
        const val MAX_INGREDIENT_ERROR_MESSAGE = "Maximum number of ingredient reached." //TODO
        const val MIN_INGREDIENT_ERROR_MESSAGE = "No ingredient can be deleted."
    }

    private val _meal: MutableStateFlow<Meal> = MutableStateFlow(Meal())
    val meal = _meal

    private var _ingredientMeasurementList = mutableListOf<Pair<String, String>>()

    override val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
        }

    fun onSaveRecipeClick() {
        // TODO add data validation
        this.launchCoroutineIO {
            _ingredientMeasurementList.forEach { (ingredient, measurement) ->
            }
            saveMealUseCase.invoke(_meal.value)
        }
    }

    fun onMealNameChange(input: String){
        _meal.value = _meal.value.copy(mealName = input)
    }

    fun onThumbnailUrlChange(input: String){
        _meal.value = _meal.value.copy(thumbnail = input)
    }

    fun onAreaChange(input: String){
        _meal.value = _meal.value.copy(area = input)
    }

    fun onCategoryChange(input: String){
        _meal.value = _meal.value.copy(category = input)
    }

    fun onYoutubeUrlChange(input: String){
        _meal.value = _meal.value.copy(youtube = input)
        if (!validateYoutubeUrl(input)) {  }
    }

    fun onInstructionChange(input: String) { _meal.value = _meal.value.copy(instructions = input) }

    fun onAddIngredientClick(
        ingredient: String,
        measurement: String,
        onSuccess: () -> Unit
    ) {
        this.launchCoroutineMain {
            if (_ingredientMeasurementList.size == MAX_INGREDIENT_COUNT) {
//                throw Exception()
            } else {
                val ingredientMeasurementPair = ingredient to measurement
                _ingredientMeasurementList.add(ingredientMeasurementPair)
                onSuccess.invoke()
            }
        }
    }

    fun onDeleteIngredientClick(
        ingredient: String,
        measurement: String,
        onSuccess: () -> Unit
    ) {
        this.launchCoroutineMain {
            if (_ingredientMeasurementList.size == 0) {
//                throw Exception()
            } else {
                val indexOfElementToRemove = _ingredientMeasurementList.indexOf(ingredient to measurement)
                _ingredientMeasurementList.removeAt(indexOfElementToRemove)
                onSuccess.invoke()
            }
        }
    }
}