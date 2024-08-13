package com.example.whatToEat.ui.mealDetail

import androidx.lifecycle.viewModelScope
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.domain.useCases.DeleteSavedMealUseCase
import com.example.whatToEat.domain.useCases.GetMealDetailByIdUseCase
import com.example.whatToEat.domain.useCases.SaveMealUseCase
import com.example.whatToEat.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val getMealDetailByIdUseCase: GetMealDetailByIdUseCase,
    private val saveMealUseCase: SaveMealUseCase,
    private val deleteSavedMealUseCase: DeleteSavedMealUseCase
): BaseViewModel() {

    private val _meal: MutableStateFlow<MealUiModel?> = MutableStateFlow(null)
    val meal: StateFlow<MealUiModel?> = _meal
    private var _mealObject: Meal? = null

    private val _isSaved: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val isSaved: StateFlow<Boolean?> = _isSaved

    override val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            println("------------------ exception: ${exception.message}")
            _meal.value = MealUiModel.Error(exception.message ?: "Error")
        }

    fun fetchMeal(uid: Int, apiId: Int) {
        viewModelScope.launch {
            _isSaved.value = uid >= 0
        }
        this.launchCoroutineIO {
            _meal.value = MealUiModel.Loading
            getMealDetailByIdUseCase.invoke(uid, apiId)
                .collect {
                    _meal.value = MealUiModel.Success(it)
                    _mealObject = it
                }
        }
    }

    fun onFavButtonClick() {
        _isSaved.value?.let { safeIsSaved ->
            if (safeIsSaved) {
                deleteSavedMeal()
            } else {
                saveMeal()
            }
        }
    }

    private fun saveMeal() {
        this.launchCoroutineIO {
            _mealObject?.let {
                saveMealUseCase.invoke(it)
                _isSaved.value = true
            } ?: throw Exception("Error")
        }
    }

    private fun deleteSavedMeal() {
        this.launchCoroutineIO {
            _mealObject?.let {
                deleteSavedMealUseCase.invoke(uid = it.uid, apiId = it.apiId)
                _isSaved.value = false
            } ?: throw Exception("Error")
        }
    }
}