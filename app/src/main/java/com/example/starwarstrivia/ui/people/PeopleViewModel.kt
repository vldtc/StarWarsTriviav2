package com.example.starwarstrivia.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {
    val people = MutableLiveData<PeopleModel>()

    fun loadMorePeople(next: String) {
        viewModelScope.launch {
            people.postValue(repository.getPeople(next))
        }
    }

    fun loadPeople() {
        viewModelScope.launch {
            people.postValue(repository.getPeople())
        }
    }
}
