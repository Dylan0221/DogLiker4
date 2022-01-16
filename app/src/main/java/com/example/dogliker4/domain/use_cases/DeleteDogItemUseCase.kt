package com.example.dogliker4.domain.use_cases

import com.example.dogliker4.domain.repository.DogLikerRepository
import javax.inject.Inject

class DeleteDogItemUseCase @Inject constructor(
    private val repository: DogLikerRepository
) {

    suspend operator fun invoke(image: String){
        repository.deleteDogItem(image)
    }
}