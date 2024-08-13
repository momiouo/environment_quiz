package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import javax.inject.Inject

class ResetIsGoodAnswerCounterUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke() {
        Log.d("ResetIsGoodAnswerCounterUseCase", "invoke() called")
        repository.resetIsGoodAnswerCounter()
    }

}