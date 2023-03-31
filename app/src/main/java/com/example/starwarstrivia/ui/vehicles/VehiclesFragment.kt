package com.example.starwarstrivia.ui.vehicles

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesResultModel
import com.example.starwarstrivia.databinding.FragmentPeopleBinding
import com.example.starwarstrivia.databinding.FragmentVehiclesBinding
import com.example.starwarstrivia.ui.people.PeopleAdapter
import com.example.starwarstrivia.ui.people.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehiclesFragment : Fragment() {


    private var vehiclesAdapter: VehiclesAdapter? = null

    private var _binding: FragmentVehiclesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<VehiclesViewModel>()
    private val sharedViewModel by activityViewModels<VehiclesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVehiclesBinding.inflate(inflater, container, false)

        setupUI()

        viewModel.vehicles.observe(viewLifecycleOwner) {
            it?.let {
                updateAdapterValues(it)
            }
        }

        viewModel.loadVehicles()

        return binding.root
    }

    private fun updateAdapterValues(vehiclesResultModel: VehiclesModel) {
        vehiclesAdapter?.addMoreItems(vehiclesResultModel.results as List<VehiclesResultModel>)
    }

    fun setupUI() {
        vehiclesAdapter = VehiclesAdapter(mutableListOf())
        binding.rvVehicles.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = vehiclesAdapter
        }

        binding.nsvPeople.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                viewModel.vehicles.value?.let {
                    if (!it.next.isNullOrEmpty()) {
                        viewModel.loadMoreVehicles(it.next)
                    }
                }
            }
        }

        vehiclesAdapter?.onItemClick = {
            val bundle = Bundle().apply {
                putString("VehiclesId", it.url)
            }
            findNavController().navigate(
                R.id.action_nav_vehicles_to_vehiclesFragment, bundle
            )
        }

    }
}