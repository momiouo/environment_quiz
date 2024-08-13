package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import javax.inject.Inject

class SaveIsGoodAnswerUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(isGoodAnswer: Boolean) {
        Log.d("SaveIsGoodAnswerUseCase", "invoke() called with: isGoodAnswer = $isGoodAnswer")
        repository.saveIsGoodAnswer(isGoodAnswer)
    }

}