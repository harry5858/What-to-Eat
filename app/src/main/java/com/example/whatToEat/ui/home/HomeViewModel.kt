package com.example.whatToEat.ui.home

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.domain.useCases.GetRandomMealUseCase
import com.example.whatToEat.domain.util.Error
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

    fun onRollClick() {
        this.launchCoroutineIO {
            _meal.value = MealUiModel.Loading
            getRandomMealUseCase.invoke()
                .collect {
                    when (it) {
                        is Result.Error -> {
                            _meal.value = MealUiModel.Failure(it.error)
                        }
                        is Result.Success -> { _meal.value = MealUiModel.Success(data = it.data) }
                    }
                }
        }
    }
}