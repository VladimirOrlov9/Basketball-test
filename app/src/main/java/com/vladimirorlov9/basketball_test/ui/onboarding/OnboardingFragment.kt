package com.vladimirorlov9.basketball_test.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vladimirorlov9.basketball_test.R
import com.vladimirorlov9.basketball_test.databinding.FragmentOnboardingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

const val SPECIFICATION_ONBOARDING = "onboarding"

class OnboardingFragment : Fragment() {

    private lateinit var onboardingAdapter: OnboardingAdapter

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val spec = requireActivity().getPreferences(Context.MODE_PRIVATE)
            .getBoolean(SPECIFICATION_ONBOARDING, false)
        if (spec)
            findNavController().navigate(R.id.action_onboardingFragment_to_liveScoreFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onboardingAdapter = OnboardingAdapter(this, boardsContent)
        binding.pager.adapter = onboardingAdapter

        TabLayoutMediator(binding.pagerTabs, binding.pager) { tab, _ ->
            tab.view.isClickable = false;
        }.attach()
        binding.pagerTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    (boardsContent.size - 1) -> {
                        binding.skipButton.visibility = View.INVISIBLE
                        binding.nextButton.visibility = View.INVISIBLE

                        binding.finishButton.visibility = View.VISIBLE
                    }
                    else -> {
                        binding.skipButton.visibility = View.VISIBLE
                        binding.nextButton.visibility = View.VISIBLE

                        binding.finishButton.visibility = View.INVISIBLE
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // nothing to do
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // nothing to do
            }
        })

        binding.nextButton.setOnClickListener {
            val currentPage = binding.pagerTabs.selectedTabPosition
            binding.pager.setCurrentItem(currentPage + 1, true)
        }
        binding.skipButton.setOnClickListener {
            val pagesNum = binding.pagerTabs.tabCount
            binding.pager.setCurrentItem(pagesNum - 1, true)
        }
        binding.finishButton.setOnClickListener {
            finishOnboard()
            findNavController().navigate(R.id.action_onboardingFragment_to_liveScoreFragment)
        }
    }

    private fun finishOnboard() {
        val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        with (pref.edit()) {
            putBoolean(SPECIFICATION_ONBOARDING, true)
            apply()
        }
    }
}