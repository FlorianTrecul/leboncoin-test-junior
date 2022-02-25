package com.floriantrecul.leboncointestjunior.di

import com.floriantrecul.leboncointestjunior.data.data_source.remote.mapper.AlbumDtoMapper
import com.floriantrecul.leboncointestjunior.data.mapper.AlbumMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideAlbumDtoMapper(): AlbumDtoMapper = AlbumDtoMapper()

    @Singleton
    @Provides
    fun provideAlbumMapper(): AlbumMapper = AlbumMapper()
}