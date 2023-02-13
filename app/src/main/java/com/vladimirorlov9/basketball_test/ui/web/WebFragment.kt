package com.vladimirorlov9.basketball_test.ui.web

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirorlov9.basketball_test.databinding.FragmentWebBinding

/**
 * Fragment to display WebView element
 */
class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupWebView()
    }

    private fun setupWebView() {
        binding.webView.loadUrl("https://basketballireland.tv/home")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}