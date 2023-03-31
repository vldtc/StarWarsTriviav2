package com.example.starwarstrivia.ui.starships.starshipsdetailed

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
import com.example.starwarstrivia.ui.people.PeopleViewModel
import com.example.starwarstrivia.ui.species.speciesdetailed.SpeciesDetailedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipsDetailedFragment : Fragment() {

    private var _binding: FragmentSpeciesDetailedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SpeciesDetailedViewModel>()
    private val sharedViewModel by activityViewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpeciesDetailedBinding.inflate(inflater, container, false)

        return binding.root
    }


}