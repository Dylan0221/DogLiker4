package com.example.dogliker4.data.repository

import com.example.dogliker4.data.local.dao.DogLikerDao
import com.example.dogliker4.data.local.entity.DogItemEntity
import com.example.dogliker4.data.remote.api_service.DogApiService
import com.example.dogliker4.data.remote.dto.DogItemDto
import com.example.dogliker4.domain.repository.DogLikerRepository
import javax.inject.Inject


class DogLikerRepositoryImpl @Inject constructor(
    private val api: DogApiService,
    private val dao: DogLikerDao
): DogLikerRepository {
    override suspend fun getDogDto(): DogItemDto =
        api.getDog()


    override suspend fun addDogItem(dogItem: DogItemEntity) {
        dao.insertDogItem(dogItem)
    }

    override suspend fun deleteDogItem(image: String) {

        dao.deleteDogItem(image)
    }

    override suspend fun getAllDogItemEntity(): List<DogItemEntity> =
        dao.getALl()


}