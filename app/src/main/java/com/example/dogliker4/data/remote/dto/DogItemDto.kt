package com.example.dogliker4.data.remote.dto

import com.example.dogliker4.domain.model.DogItem

data class DogItemDto(
    val message: String,
    val status: String
){
    fun toDogItem(): DogItem =
        DogItem(
            image = message,
            status = status,
        )
}