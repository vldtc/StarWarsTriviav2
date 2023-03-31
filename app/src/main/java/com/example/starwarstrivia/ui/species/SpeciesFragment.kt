package com.example.starwarstrivia.ui.species

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.model.species.SpeciesResultModel
import com.example.starwarstrivia.databinding.FragmentSpeciesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpeciesFragment : Fragment() {

    private var speciesAdapter: SpeciesAdapter? = null

    private var _binding: FragmentSpeciesBinding? = null
    private val binding get() = _binding!!

    private val speciesViewModel by viewModels<SpeciesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSpeciesBinding.inflate(inflater, container, false)

        setupUI()

        speciesViewModel.species.observe(viewLifecycleOwner){
            it?.let {
                updateAdapterValues(it)
            }
        }

        speciesViewModel.loadSpecies()

        return binding.root
    }

    private fun updateAdapterValues(speciesResultModel: SpeciesModel) {
        speciesAdapter?.addMoreItems(speciesResultModel.results as List<SpeciesResultModel>)
    }

    fun setupUI() {
        speciesAdapter = SpeciesAdapter(mutableListOf())
        binding.rvSpecies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = speciesAdapter
        }

        binding.nsvSpecies.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                speciesViewModel.species.value?.let {
                    if (!it.next.isNullOrEmpty()) {
                        speciesViewModel.loadMoreSpecies(it.next)
                    }
                }
            }
        }

        speciesAdapter?.onItemClick = {
            val bundle = Bundle().apply {
                putString("SpeciesId", it.url)
            }
            findNavController().navigate(
                R.id.action_SpeciesDetailed, bundle
            )
        }

    }

}