package com.floriantrecul.leboncointestjunior.di

import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import com.floriantrecul.leboncointestjunior.domain.use_case.AlbumUseCases
import com.floriantrecul.leboncointestjunior.domain.use_case.LoadAlbumsUseCase
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
    fun provideAlbumUseCases(
        albumRepository: AlbumRepository
    ): AlbumUseCases {
        return AlbumUseCases(
            loadAlbums = LoadAlbumsUseCase(albumRepository)
        )
    }
}