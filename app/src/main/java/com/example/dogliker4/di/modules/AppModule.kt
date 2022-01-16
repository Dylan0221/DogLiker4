package com.example.dogliker4.di.modules

import android.app.Application
import androidx.room.Room
import com.example.dogliker4.data.local.dao.DogLikerDao
import com.example.dogliker4.data.local.database.DogDatabase
import com.example.dogliker4.data.remote.api_service.DogApiService
import com.example.dogliker4.data.repository.DogLikerRepositoryImpl
import com.example.dogliker4.domain.repository.DogLikerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun providesDogApi():DogApiService =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)

    @Provides
    @Singleton
    fun providesDogRepository(api: DogApiService, dao: DogLikerDao): DogLikerRepository = DogLikerRepositoryImpl(api, dao)

    @Provides
    @Singleton
    fun providesDataBase(app: Application) =
        Room.databaseBuilder(app, DogDatabase::class.java, "Liked_dogs_Database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providesDogDao(db: DogDatabase): DogLikerDao =
        db.dogLikerDao()

}