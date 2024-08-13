package com.example.whatToEat.ui.mealDetail

import androidx.lifecycle.viewModelScope
import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.Meal
import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.domain.useCases.CheckIsMealAlreadySavedUseCase
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
    private val deleteSavedMealUseCase: DeleteSavedMealUseCase,
    private val checkIsMealAlreadySavedUseCase: CheckIsMealAlreadySavedUseCase
): BaseViewModel() {

    private val _meal: MutableStateFlow<MealUiModel?> = MutableStateFlow(null)
    val meal: StateFlow<MealUiModel?> = _meal
    private var _mealObject: Meal? = null

    private val _isSaved: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val isSaved: StateFlow<Boolean?> = _isSaved

    fun fetchMeal(uid: Int, apiId: Int) {
        println("------------------ fetchMeal called uid -- $uid apiId -- $apiId")
        this.launchCoroutineIO {
            if (uid >= 0) {
                _isSaved.value = true
            } else {
                when (val hasDbEntry = checkIsMealAlreadySavedUseCase.invoke(apiId)) {
                    is Result.Error -> {
                        _meal.value = MealUiModel.Failure(hasDbEntry.error)
                        _isSaved.value = false
                    }
                    is Result.Success -> {
                        _isSaved.value = hasDbEntry.data
                    }
                }
            }
        }
//        viewModelScope.launch {
//            _isSaved.value = uid >= 0
//        }
        this.launchCoroutineIO {
            _meal.value = MealUiModel.Loading
            getMealDetailByIdUseCase.invoke(uid, apiId)
                .collect {
                    when (it) {
                        is Result.Error -> { _meal.value = MealUiModel.Failure(it.error) }
                        is Result.Success -> {
                            _meal.value = MealUiModel.Success(it.data)
                            _mealObject = it.data
                        }
                    }
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