package com.example.starwarstrivia.ui.vehicles.vehiclesdetailed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.starwarstrivia.R
import com.example.starwarstrivia.databinding.FragmentSpeciesDetailedBinding
import com.example.starwarstrivia.databinding.FragmentVehiclesDetailedBinding
import com.example.starwarstrivia.ui.people.PeopleViewModel
import com.example.starwarstrivia.ui.species.speciesdetailed.SpeciesDetailedViewModel

class VehiclesDetailedFragment : Fragment() {

    private var _binding: FragmentVehiclesDetailedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SpeciesDetailedViewModel>()
    private val sharedViewModel by activityViewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            _binding = FragmentVehiclesDetailedBinding.inflate(inflater, container, false)

            return binding.root
        }
    }


