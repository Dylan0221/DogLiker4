package com.example.dogliker4.domain.repository

import com.example.dogliker4.data.local.entity.DogItemEntity
import com.example.dogliker4.data.remote.dto.DogItemDto
import com.example.dogliker4.domain.model.DogItem
import kotlinx.coroutines.flow.Flow

interface DogLikerRepository {

    suspend fun getDogDto(): DogItemDto

    suspend fun addDogItem(dogItem: DogItemEntity)

    suspend fun deleteDogItem(image: String)

    suspend fun getAllDogItemEntity(): List<DogItemEntity>

}