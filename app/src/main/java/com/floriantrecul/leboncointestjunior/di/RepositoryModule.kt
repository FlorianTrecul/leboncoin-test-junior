package com.floriantrecul.leboncointestjunior.di

import com.floriantrecul.leboncointestjunior.data.data_source.remote.mapper.AlbumDtoMapper
import com.floriantrecul.leboncointestjunior.data.data_source.remote.service.ApiService
import com.floriantrecul.leboncointestjunior.data.respository.AlbumRepositoryImpl
import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAlbumRepository(
        apiService: ApiService,
        albumDtoMapper: AlbumDtoMapper
    ): AlbumRepository = AlbumRepositoryImpl(apiService, albumDtoMapper)
}