package com.vladimirorlov9.basketball_test.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.vladimirorlov9.basketball_test.databinding.FragmentOnboardElementBinding

/**
 * Element Instance for pager
 */
class OnboardElementFragment : Fragment() {

    private var _binding: FragmentOnboardElementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(ONBOARD_ARG_LABEL) }?.apply {
            binding.label.text = getString(ONBOARD_ARG_LABEL)
        }
        arguments?.takeIf { it.containsKey(ONBOARD_ARG_ARTICLE) }?.apply {
            binding.article.text = getString(ONBOARD_ARG_ARTICLE)
        }
        arguments?.takeIf { it.containsKey(ONBOARD_ARG_IMAGE) }?.apply {
            binding.image.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    getInt(ONBOARD_ARG_IMAGE),
                    null
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}