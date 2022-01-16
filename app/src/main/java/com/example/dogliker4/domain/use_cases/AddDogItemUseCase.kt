package com.example.dogliker4.domain.use_cases

import com.example.dogliker4.data.local.entity.DogItemEntity
import com.example.dogliker4.domain.repository.DogLikerRepository
import javax.inject.Inject

class AddDogItemUseCase @Inject constructor(
    private val repository: DogLikerRepository
) {

    suspend operator fun invoke(item: DogItemEntity) =
        repository.addDogItem(item)

}