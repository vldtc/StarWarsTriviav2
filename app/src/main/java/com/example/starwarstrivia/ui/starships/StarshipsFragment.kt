package com.example.starwarstrivia.ui.starships

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.starships.StarshipsModel
import com.example.starwarstrivia.data.model.starships.StarshipsResultModel
import com.example.starwarstrivia.databinding.FragmentStarshipsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipsFragment : Fragment() {


    private var starshipsAdapter: StarshipsAdapter? = null

    private var _binding: FragmentStarshipsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<StarshipsViewModel>()
    private val sharedViewModel by activityViewModels<StarshipsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStarshipsBinding.inflate(inflater, container, false)

        setupUI()

        viewModel.starships.observe(viewLifecycleOwner) {
            it?.let {
                updateAdapterValues(it)
            }
        }

        viewModel.loadStarships()

        return binding.root
    }

    private fun updateAdapterValues(starshipsResultModel: StarshipsModel) {
        starshipsAdapter?.addMoreItems(starshipsResultModel.results as List<StarshipsResultModel>)
    }

    fun setupUI() {
        starshipsAdapter = StarshipsAdapter(mutableListOf())
        binding.rvStarships.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = starshipsAdapter
        }

        binding.nsvPeople.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                viewModel.starships.value?.let {
                    if (!it.next.isNullOrEmpty()) {
                        viewModel.loadMoreStarships(it.next)
                    }
                }
            }
        }

        starshipsAdapter?.onItemClick = {
            val bundle = Bundle().apply {
                putString("StarshipsId", it.url)
            }
            findNavController().navigate(
                R.id.action_nav_starships_to_starshipsFragment, bundle
            )
        }

    }
}