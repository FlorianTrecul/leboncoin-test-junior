package com.floriantrecul.leboncointestjunior.domain.use_case

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import com.floriantrecul.leboncointestjunior.util.Resource

class LoadAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {

    suspend operator fun invoke(): Resource<List<AlbumEntity>> {
        return albumRepository.loadAlbums()
    }

}