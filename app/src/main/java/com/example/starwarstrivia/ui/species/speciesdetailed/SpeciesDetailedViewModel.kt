package com.example.starwarstrivia.ui.species.speciesdetailed

import androidx.lifecycle.ViewModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpeciesDetailedViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
}