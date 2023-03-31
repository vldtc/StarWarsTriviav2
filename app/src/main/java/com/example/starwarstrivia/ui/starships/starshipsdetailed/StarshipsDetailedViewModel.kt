package com.example.starwarstrivia.ui.starships.starshipsdetailed

import androidx.lifecycle.ViewModel
import com.example.starwarstrivia.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarshipsDetailedViewModel  @Inject constructor(
    val repository: Repository
) : ViewModel() {

}