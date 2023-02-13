package com.vladimirorlov9.basketball_test.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

const val ONBOARD_ARG_LABEL = "onboard_label"
const val ONBOARD_ARG_ARTICLE = "onboard_article"
const val ONBOARD_ARG_IMAGE = "onboard_image"

class OnboardingAdapter(
    fragment: Fragment,
    private val dataList: List<BoardContent>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = dataList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = OnboardElementFragment()
        val content = dataList[position]

        fragment.arguments = Bundle().apply {
            putString(ONBOARD_ARG_LABEL, content.label)
            putString(ONBOARD_ARG_ARTICLE, content.article)
            putInt(ONBOARD_ARG_IMAGE, content.imageResId)
        }
        return fragment
    }

}