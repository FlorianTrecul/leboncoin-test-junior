package com.floriantrecul.leboncointestjunior.domain.use_case

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import com.floriantrecul.leboncointestjunior.util.Resource
import kotlinx.coroutines.flow.Flow

class LoadAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<AlbumEntity>>> {
        return albumRepository.loadAlbums()
    }

}