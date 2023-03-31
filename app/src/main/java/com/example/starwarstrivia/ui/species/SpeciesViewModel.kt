package com.example.starwarstrivia.ui.species

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeciesViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val species = MutableLiveData<SpeciesModel>()

    fun loadMoreSpecies(next: String) {
            viewModelScope.launch {
                species.postValue(repository.getSpecies(next))
            }

    }

    fun loadSpecies() {
        viewModelScope.launch {
            species.postValue(repository.getSpecies())
        }
    }

}