package com.vladimirorlov9.basketball_test.domain.repository

import com.vladimirorlov9.basketball_test.domain.model.LiveMatch

interface BasketballRepository {

    suspend fun loadLiveMatches(): List<LiveMatch>
}