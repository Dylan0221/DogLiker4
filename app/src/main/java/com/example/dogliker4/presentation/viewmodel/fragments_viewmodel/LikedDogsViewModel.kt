package com.example.dogliker4.presentation.viewmodel.fragments_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogliker4.domain.model.DogItem
import com.example.dogliker4.domain.use_cases.GetAllDogItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikedDogsViewModel @Inject constructor(
    private val getAllDogItemUseCase: GetAllDogItemUseCase
): ViewModel() {

/*    var likedDogs: List<DogItem> = emptyList()

    init {
        getLikedDogs()
    }


    fun getLikedDogs(){
        viewModelScope.launch {
            getAllDogItemUseCase().collect {
                likedDogs = it
            }
        }
    }


 */

}