package com.vladimirorlov9.basketball_test.data.api.model.allsportsapi

import com.google.gson.annotations.SerializedName

data class Scores(
    @SerializedName("1stQuarter") val firstQuarter: List<Quarter>,
    @SerializedName("2ndQuarter") val secondQuarter: List<Quarter>,
    @SerializedName("3rdQuarter") val thirdQuarter: List<Quarter>,
    @SerializedName("4thQuarter") val fourthQuarter: List<Quarter>
)