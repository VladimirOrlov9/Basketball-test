package com.vladimirorlov9.basketball_test.data.repository

import android.icu.util.TimeZone
import com.vladimirorlov9.basketball_test.data.BuildConfig
import com.vladimirorlov9.basketball_test.data.api.model.allsportsapi.LiveScoreResponse
import com.vladimirorlov9.basketball_test.data.api.model.allsportsapi.Scores
import com.vladimirorlov9.basketball_test.data.api.retrofit2.AllSportsApiService
import com.vladimirorlov9.basketball_test.domain.model.LiveMatch
import com.vladimirorlov9.basketball_test.domain.model.QuarterStat
import com.vladimirorlov9.basketball_test.domain.repository.BasketballRepository

class BasketballRepositoryImpl(
    private val allSportsApiService: AllSportsApiService
) : BasketballRepository {

    override suspend fun loadLiveMatches(): List<LiveMatch> {
        val call = allSportsApiService.getLiveMatches(
            apiKey = BuildConfig.ALL_SPORTS_API_KEY,
            timeZone = TimeZone.getDefault().id
        )
        val response = call.execute()
        return response.body()?.mapToListOfLiveMatch() ?: listOf()
    }

    private fun LiveScoreResponse.mapToListOfLiveMatch(): List<LiveMatch> {

        return this.result.map { item ->
            LiveMatch(
                eventId = item.event_key,
                eventDate = item.event_date,
                eventTime = item.event_time,
                eventHomeTeam = item.event_home_team,
                eventHomeTeamId = item.home_team_key,
                eventHomeTeamLogo = item.event_home_team_logo,
                eventAwayTeam = item.event_away_team,
                eventAwayTeamId = item.away_team_key,
                eventAwayTeamLogo = item.event_away_team_logo,
                eventFinalResult = item.event_final_result,
                leagueName = item.league_name,
                leagueId = item.league_key,
                countryName = item.country_name,
                leagueSeason = item.league_season,
                eventStatus = item.event_status,
                scores = item.scores.mapToQuarterStats()
            )
        }
    }

    private fun Scores.mapToQuarterStats(): List<QuarterStat> {
        val quarterStatsList = mutableListOf<QuarterStat>()

        // TODO api error, find a way to simplify
        this.firstQuarter.firstOrNull()?.let {
            quarterStatsList.add(
                QuarterStat(
                    scoreHome = it.score_home,
                    scoreAway = it.score_away
                )
            )
        }
        this.secondQuarter.firstOrNull()?.let {
            quarterStatsList.add(
                QuarterStat(
                    scoreHome = it.score_home,
                    scoreAway = it.score_away
                )
            )
        }
        this.thirdQuarter.firstOrNull()?.let {
            quarterStatsList.add(
                QuarterStat(
                    scoreHome = it.score_home,
                    scoreAway = it.score_away
                )
            )
        }
        this.fourthQuarter.firstOrNull()?.let {
            quarterStatsList.add(
                QuarterStat(
                    scoreHome = it.score_home,
                    scoreAway = it.score_away
                )
            )
        }

        return quarterStatsList
    }
}