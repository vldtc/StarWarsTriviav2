package com.example.starwarstrivia.ui.planets.planetsdetailed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.databinding.FragmentPeopleDetailedBinding
import com.example.starwarstrivia.databinding.FragmentPlanetsDetailedBinding
import com.example.starwarstrivia.databinding.FragmentSpeciesDetailedBinding
import com.example.starwarstrivia.ui.people.PeopleViewModel
import com.example.starwarstrivia.ui.people.peopledetailed.PeopleDetailedAdapter
import com.example.starwarstrivia.ui.people.peopledetailed.PeopleDetailedViewModel
import com.example.starwarstrivia.ui.planets.PlanetsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetsDetailedFragment : Fragment() {

    private var _binding: FragmentPlanetsDetailedBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetsDetailedBinding.inflate(inflater, container, false)

        return binding.root
    }




}