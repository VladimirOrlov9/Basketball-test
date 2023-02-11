package com.vladimirorlov9.basketball_test.domain.model

data class LiveMatch(
    val eventId: Int,
    val eventDate: String,
    val eventTime: String,
    val eventHomeTeam: String,
    val eventHomeTeamId: Int,
    val eventHomeTeamLogo: String?,
    val eventAwayTeam: String,
    val eventAwayTeamId: Int,
    val eventAwayTeamLogo: String?,
    val eventFinalResult: String,
    val leagueName: String,
    val leagueId: Int,
    val countryName: String,
    val leagueSeason: String,
    val eventStatus: String,
    val scores: List<QuarterStat>
)

data class QuarterStat(
    val scoreHome: Int,
    val scoreAway: Int
)
