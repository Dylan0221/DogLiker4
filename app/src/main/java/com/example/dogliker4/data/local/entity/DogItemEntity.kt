package com.example.dogliker4.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dogliker4.domain.model.DogItem


@Entity(tableName = "liked_dogs")
data class DogItemEntity(
    @PrimaryKey
    val id: Int? = null,
    val image: String,
    val status: String,
){
    fun toDogItem(): DogItem =
        DogItem(
            id = id,
            image = image,
            status = status,
        )
}
