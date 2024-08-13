package com.example.whatToEat.ui.savedMeals

import com.example.whatToEat.domain.model.MealsUiModel
import com.example.whatToEat.domain.useCases.GetAllSavedMealsUseCase
import com.example.whatToEat.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SavedMealsViewModel @Inject constructor(
    private val getAllSavedMealsUseCase: GetAllSavedMealsUseCase,

): BaseViewModel() {

    private val _meals: MutableStateFlow<MealsUiModel?> = MutableStateFlow(null)
    val meals: StateFlow<MealsUiModel?> = _meals

    override val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
        }

    fun fetchSavedMeals() {
        this.launchCoroutineIO {
            _meals.value = MealsUiModel.Loading
            getAllSavedMealsUseCase.invoke()
                .collect {
                    _meals.value = MealsUiModel.Success(it)
                }
        }
    }
}