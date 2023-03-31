package com.example.starwarstrivia.ui.vehicles.vehiclesdetailed

import androidx.lifecycle.ViewModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehiclesDetailedViewModel  @Inject constructor(
    val repository: Repository
): ViewModel() {
}