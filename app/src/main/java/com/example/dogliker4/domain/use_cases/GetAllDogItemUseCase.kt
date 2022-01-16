package com.example.dogliker4.domain.use_cases

import com.example.dogliker4.domain.model.DogItem
import com.example.dogliker4.domain.repository.DogLikerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllDogItemUseCase @Inject constructor(
    private val repository: DogLikerRepository
){

    operator fun invoke(): Flow<List<DogItem>> = flow {
        val likedDogs = repository.getAllDogItemEntity().map {
            it.toDogItem()
        }

        emit(likedDogs)
    }

}