package com.example.starwarstrivia.ui.people.peopledetailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.data.model.people.PeopleDetailedModel
import com.example.starwarstrivia.databinding.FragmentPeopleDetailedBinding
import com.example.starwarstrivia.ui.people.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailedFragment : Fragment() {

    private var _binding: FragmentPeopleDetailedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PeopleDetailedViewModel>()
    private val sharedViewModel by activityViewModels<PeopleViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeopleDetailedBinding.inflate(inflater, container, false)

        val people = arguments?.getString("PeopleId")

        viewModel.people.observe(viewLifecycleOwner) {
            it?.let {
                populatePeopleDetailed()
            }
        }

        viewModel.getPeopleID(people)

        return binding.root
    }

    fun populatePeopleDetailed() {
        val peopleDetailedAdapter = PeopleDetailedAdapter(listOf())
        binding.rvPeopleDetailed.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = peopleDetailedAdapter
        }
    }


}