package com.example.starwarstrivia.ui.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.planets.PlanetsModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val planets = MutableLiveData<PlanetsModel>()

    fun loadMorePlanets(next: String) {
        viewModelScope.launch {
            planets.postValue(repository.getPlanets(next))
        }
    }

    fun loadPlanets() {
        viewModelScope.launch {
            planets.postValue(repository.getPlanets())
        }
    }
}