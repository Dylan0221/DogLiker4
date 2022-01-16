package com.example.dogliker4.presentation.viewmodel.fragments_viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogliker4.data.local.entity.DogItemEntity
import com.example.dogliker4.domain.model.DogItem
import com.example.dogliker4.domain.use_cases.AddDogItemUseCase
import com.example.dogliker4.domain.use_cases.DeleteDogItemUseCase
import com.example.dogliker4.domain.use_cases.GetDogDtoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addDogItemUseCase: AddDogItemUseCase,
    private val getDogDtoUseCase: GetDogDtoUseCase,
    private val deleteDogItemUseCase: DeleteDogItemUseCase
): ViewModel(){

    var dogItem: DogItem? = null


    init {
        Log.d(TAG, "HomeVM: Initialized")

        getDog()
    }


    fun getDog() =
        viewModelScope.launch {
            try {
                getDogDtoUseCase().collect { value ->
                    dogItem = value
                }
                Log.d(TAG, "getDog: Succesful")
            } catch(e:HttpException) {
                dogItem = DogItem(
                    image = "",
                    status = "error",
                )
                Log.d(TAG, "getDog: Failed")
            }
        }

    fun addDogItem(dogItem: DogItem) =
        viewModelScope.launch {
            addDogItemUseCase(dogItem.toDogItemEntity())
            Log.d(TAG, "addDogItem: Dog Added")
        }

    fun deleteDogItem(image: String) =
        viewModelScope.launch {
            deleteDogItemUseCase(image)
            Log.d(TAG, "deleteDogItem: Dog Deleted")
        }




}