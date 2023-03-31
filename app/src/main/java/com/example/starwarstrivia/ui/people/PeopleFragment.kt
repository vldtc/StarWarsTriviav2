package com.example.starwarstrivia.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {


    private var peopleAdapter: PeopleAdapter? = null

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<PeopleViewModel>()
    private val sharedViewModel by activityViewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)

        setupUI()

        viewModel.people.observe(viewLifecycleOwner) {
            it?.let {
                updateAdapterValues(it)
            }
        }

        viewModel.loadPeople()

        return binding.root
    }

    private fun updateAdapterValues(peopleResultModel: PeopleModel) {
        peopleAdapter?.addMoreItems(peopleResultModel.results as List<PeopleResultModel>)
    }

    fun setupUI() {
        peopleAdapter = PeopleAdapter(mutableListOf())
        binding.rvPeople.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = peopleAdapter
        }

        binding.nsvPeople.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                viewModel.people.value?.let {
                    if (!it.next.isNullOrEmpty()) {
                        viewModel.loadMorePeople(it.next)
                    }
                }
            }
        }

        peopleAdapter?.onItemClick = {
            val bundle = Bundle().apply {
                putString("PeopleId", it.url)
            }
            findNavController().navigate(
                R.id.action_PeopleDetailed, bundle
            )
        }

    }
}