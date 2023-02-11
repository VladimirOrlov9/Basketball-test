package com.vladimirorlov9.basketball_test.data.api.model.allsportsapi

data class Result(
    val away_team_key: Int,
    val country_name: String,
    val event_away_team: String,
    val event_away_team_logo: String?,
    val event_date: String,
    val event_final_result: String,
    val event_home_team: String,
    val event_home_team_logo: String?,
    val event_key: Int,
    val event_live: String,
    val event_quarter: String,
    val event_status: String,
    val event_time: String,
    val home_team_key: Int,
    val league_key: Int,
    val league_name: String,
    val league_round: Any,
    val league_season: String,
    val lineups: Lineups,
    val player_statistics: PlayerStatistics,
    val scores: Scores,
    val statistics: List<Any>
)