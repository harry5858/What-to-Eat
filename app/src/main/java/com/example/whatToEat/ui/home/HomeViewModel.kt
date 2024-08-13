package com.example.whatToEat.ui.home

import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.domain.useCases.GetRandomMealUseCase
import com.example.whatToEat.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase
): BaseViewModel() {

    private val _meal: MutableStateFlow<MealUiModel?> = MutableStateFlow(null)
    val meal: StateFlow<MealUiModel?> = _meal

    override val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            println("------------------ exception: ${exception.message}")
            _meal.value = MealUiModel.Error(exception.message ?: "Error")
        }

    fun onRollClick() {
        this.launchCoroutineIO {
            _meal.value = MealUiModel.Loading
            getRandomMealUseCase.invoke()
                .collect {
                    _meal.value = MealUiModel.Success(data = it)
                }
        }
    }
}