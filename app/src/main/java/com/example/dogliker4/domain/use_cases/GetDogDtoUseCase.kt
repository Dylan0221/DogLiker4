package com.example.dogliker4.domain.use_cases

import com.example.dogliker4.domain.model.DogItem
import com.example.dogliker4.domain.repository.DogLikerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDogDtoUseCase @Inject constructor(
    private val repository: DogLikerRepository
) {

    operator fun invoke(): Flow<DogItem> = flow {
        val item = repository.getDogDto().toDogItem()
        emit(item)
    }
}