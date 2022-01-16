package com.example.dogliker4.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dogliker4.data.local.dao.DogLikerDao
import com.example.dogliker4.data.local.entity.DogItemEntity


@Database(entities = [DogItemEntity::class], version = 2 , exportSchema = false)
abstract class DogDatabase: RoomDatabase() {

    abstract fun dogLikerDao(): DogLikerDao


}