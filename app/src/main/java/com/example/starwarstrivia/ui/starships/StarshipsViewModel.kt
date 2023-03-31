package com.example.starwarstrivia.ui.starships

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.starships.StarshipsModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarshipsViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {
    val starships = MutableLiveData<StarshipsModel>()

    fun loadMoreStarships(next: String) {
        viewModelScope.launch {
            starships.postValue(repository.getStarships(next))
        }
    }

    fun loadStarships() {
        viewModelScope.launch {
            starships.postValue(repository.getStarships())
        }
    }
}