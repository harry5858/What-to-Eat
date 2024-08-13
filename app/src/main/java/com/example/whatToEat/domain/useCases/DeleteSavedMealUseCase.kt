package com.example.whatToEat.domain.useCases

import com.example.whatToEat.domain.repository.MealRepository
import javax.inject.Inject

class DeleteSavedMealUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(uid: Int, apiId: Int) {
        if (uid < 0) {
            repo.deleteSavedMealByApiId(apiId)
        } else {
            repo.deleteSavedMealByUid(uid)
        }
    }
}