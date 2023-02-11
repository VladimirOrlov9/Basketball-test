package com.vladimirorlov9.basketball_test.data.api.retrofit2

import com.vladimirorlov9.basketball_test.data.api.model.allsportsapi.LiveScoreResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsApiService {

    @GET("/basketball/")
    fun getLiveMatches(
        @Query("met") met: String = "Livescore",
        @Query("APIkey") apiKey: String,
        @Query("timezone") timeZone: String
    ) : Call<LiveScoreResponse>

    companion object {
        const val BASE_URL = "https://apiv2.allsportsapi.com/"
    }
}