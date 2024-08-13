package com.example.whatToEat.domain.useCases

import com.example.whatToEat.data.util.Result
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.util.Error
import javax.inject.Inject

class CheckIsMealAlreadySavedUseCase @Inject constructor(
    private val repo: MealRepository
) {
    suspend fun invoke(apiId: Int): Result<Boolean, Error> {
        return repo.isMealEntryAlreadyExist(apiId)
    }
}