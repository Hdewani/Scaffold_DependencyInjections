package com.example.basicapp.di

import com.example.basicapp.data.repo.UserRepo
import com.example.basicapp.data.repo.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserRepo(): UserRepo {
        return UserRepoImpl()
    }

}