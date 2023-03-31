package com.example.starwarstrivia.ui.planets

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.planets.PlanetsModel
import com.example.starwarstrivia.data.model.planets.PlanetsResultModel
import com.example.starwarstrivia.databinding.FragmentPlanetsBinding
import com.example.starwarstrivia.ui.people.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetsFragment : Fragment() {

    private var planetsAdapter: PlanetsAdapter? = null

    private var _binding: FragmentPlanetsBinding? = null
    private val binding get() = _binding!!

    private val planetsViewModel by viewModels<PlanetsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetsBinding.inflate(inflater, container, false)

        setupUI()

        planetsViewModel.planets.observe(viewLifecycleOwner){
            it?.let{
                updateAdapterValues(it)
            }
        }

        planetsViewModel.loadPlanets()

        return binding.root
    }

    private fun updateAdapterValues(planetsResultModel: PlanetsModel) {
        planetsAdapter?.addMoreItems(planetsResultModel.results as List<PlanetsResultModel>)
    }

    fun setupUI() {
        planetsAdapter = PlanetsAdapter(mutableListOf())
        binding.rvPlanets.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = planetsAdapter
        }

        binding.nsvPlanets.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                planetsViewModel.planets.value?.let {
                    if (!it.next.isNullOrEmpty()) {
                        planetsViewModel.loadMorePlanets(it.next)
                    }
                }
            }
        }

        planetsAdapter?.onItemClick = {
            val bundle = Bundle().apply {
                putString("PlanetsId", it.url)
            }
            findNavController().navigate(
                R.id.action_PlanetsDetailed, bundle
            )
        }

    }

}