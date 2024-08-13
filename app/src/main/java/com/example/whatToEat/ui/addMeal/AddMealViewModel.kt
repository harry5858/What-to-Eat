package com.example.whatToEat.ui.addMeal

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.AddMealUiModel
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.model.inputIngredientMeasurementList
import com.example.whatToEat.domain.useCases.SaveCustomMealUseCase
import com.example.whatToEat.domain.useCases.SaveMealUseCase
import com.example.whatToEat.domain.util.Error
import com.example.whatToEat.domain.util.validateYoutubeUrl
import com.example.whatToEat.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddMealViewModel @Inject constructor(
    private val saveCustomMealUseCase: SaveCustomMealUseCase
): BaseViewModel() {

    companion object {
        const val MAX_INGREDIENT_COUNT = 20
    }

    private val _addMealUiModel: MutableStateFlow<AddMealUiModel?> = MutableStateFlow(null)
    val addMealUiModel: StateFlow<AddMealUiModel?> = _addMealUiModel

    private val _meal: MutableStateFlow<Meal> = MutableStateFlow(Meal())

    private var _ingredientMeasurementList = mutableListOf<Pair<String, String>>()

    fun onSaveRecipeClick() {
        this.launchCoroutineIO {
            _addMealUiModel.value = AddMealUiModel.Loading
            _meal.value = _meal.value.inputIngredientMeasurementList(_ingredientMeasurementList)
            when (val result = saveCustomMealUseCase.invoke(_meal.value)) {
                is Result.Error -> {_addMealUiModel.value = AddMealUiModel.Failure(result.error)}
                is Result.Success -> { _addMealUiModel.value = AddMealUiModel.Success }
            }
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
    }

    fun onInstructionChange(input: String) { _meal.value = _meal.value.copy(instructions = input) }

    fun onAddIngredientClick(
        ingredient: String,
        measurement: String,
        onSuccess: () -> Unit
    ) {
        this.launchCoroutineMain {
            if (_ingredientMeasurementList.size == MAX_INGREDIENT_COUNT) {
                _addMealUiModel.value = AddMealUiModel.Failure(Error.AddMealError.MaximumIngredientError)
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
            val indexOfElementToRemove = _ingredientMeasurementList.indexOf(ingredient to measurement)
            _ingredientMeasurementList.removeAt(indexOfElementToRemove)
            onSuccess.invoke()
        }
    }
}