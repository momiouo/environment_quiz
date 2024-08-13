package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGoodAnswerCounterUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(): Flow<Int> {
        Log.d("GetGoodAnswerCounterUseCase", "invoke() called")
        return repository.getGoodAnswerCounter()
    }

}