package com.vladimirorlov9.basketball_test.ui.livescore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladimirorlov9.basketball_test.databinding.FragmentLivescoreBinding
import com.vladimirorlov9.basketball_test.ui.BasketballViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LiveScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LiveScoreFragment : Fragment() {

    private var _binding: FragmentLivescoreBinding? = null
    private val binding get() = _binding!!

    private val vm by viewModel<BasketballViewModel>()
    private lateinit var recyclerAdapter: LiveScoreListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getLiveMatches()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLivescoreBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        vm.liveMatchesLD.observe(viewLifecycleOwner) {
            recyclerAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        recyclerAdapter = LiveScoreListAdapter {
            // TODO add click event
        }
        binding.recycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.recycler.adapter = recyclerAdapter
    }

}