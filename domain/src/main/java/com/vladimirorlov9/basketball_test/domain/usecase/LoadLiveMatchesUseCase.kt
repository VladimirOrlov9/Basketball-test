package com.vladimirorlov9.basketball_test.domain.usecase

import com.vladimirorlov9.basketball_test.domain.model.LiveMatch
import com.vladimirorlov9.basketball_test.domain.repository.BasketballRepository

class LoadLiveMatchesUseCase(private val basketballRepository: BasketballRepository) {

    suspend fun execute(): List<LiveMatch> {
        return basketballRepository.loadLiveMatches()
    }
}