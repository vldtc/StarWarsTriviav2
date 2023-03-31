package com.example.starwarstrivia.ui.vehicles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehiclesViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {
    val vehicles = MutableLiveData<VehiclesModel>()

    fun loadMoreVehicles(next: String) {
        viewModelScope.launch {
            vehicles.postValue(repository.getVehicles(next))
        }
    }

    fun loadVehicles() {
        viewModelScope.launch {
            vehicles.postValue(repository.getVehicles())
        }
    }
}