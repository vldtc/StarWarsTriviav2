package com.example.starwarstrivia.ui.people.peopledetailed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleDetailedViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val people = MutableLiveData<PeopleModel>()


    fun getPeopleID(id: String?){
        viewModelScope.launch {
            val result = repository.getPeopleID(id ?: "")
            people.postValue(result) // runs when we have the resources
        }
    }

}