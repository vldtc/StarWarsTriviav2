package com.example.starwarstrivia.ui.planets.planetsdetailed

import androidx.lifecycle.ViewModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetsDetailedViewModel  @Inject constructor(
    val repository: Repository
): ViewModel() {
}