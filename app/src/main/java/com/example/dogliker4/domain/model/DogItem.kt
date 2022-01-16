package com.example.dogliker4.domain.model

import androidx.room.Entity
import com.example.dogliker4.data.local.entity.DogItemEntity

data class DogItem(
    var id: Int? = null,
    val image: String,
    val status: String,
){
    fun toDogItemEntity(): DogItemEntity =
        DogItemEntity(
            image = image,
            status = status,
        )


}
