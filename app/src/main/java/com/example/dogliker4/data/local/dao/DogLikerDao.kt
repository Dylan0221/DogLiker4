package com.example.dogliker4.data.local.dao

import androidx.room.*
import com.example.dogliker4.data.local.entity.DogItemEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DogLikerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogItem(dogItem: DogItemEntity)

    @Query("DELETE FROM LIKED_DOGS WHERE image = :image")
    suspend fun deleteDogItem(image: String)

    @Query("SELECT * FROM liked_dogs")
    suspend fun getALl(): List<DogItemEntity>



}