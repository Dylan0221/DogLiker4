package com.example.dogliker4.data.remote.api_service

import com.example.dogliker4.data.remote.dto.DogItemDto
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {

    @GET("image/random")
    suspend fun getDog(): DogItemDto

}