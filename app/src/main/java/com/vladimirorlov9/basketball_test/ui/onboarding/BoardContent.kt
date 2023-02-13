package com.vladimirorlov9.basketball_test.ui.onboarding

import com.vladimirorlov9.basketball_test.R

data class BoardContent (
    val label: String,
    val article: String,
    val imageResId: Int
)

val boardsContent = listOf(
    BoardContent(
        label = "Live Matches",
        article = "See the schedule of upcoming live matches right in the app.",
        imageResId = R.drawable.board_img1
    ),
    BoardContent(
        label = "Scores",
        article = "Follow the results of the events of your favorite basketball teams.",
        imageResId = R.drawable.board_img2
    ),
    BoardContent(
        label = "Enjoy",
        article = "Enjoy life!",
        imageResId = R.drawable.board_img3
    )
)