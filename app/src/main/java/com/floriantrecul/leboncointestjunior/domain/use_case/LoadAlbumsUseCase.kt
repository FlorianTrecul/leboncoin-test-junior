package com.floriantrecul.leboncointestjunior.domain.use_case

import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import timber.log.Timber

class LoadAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {

    suspend operator fun invoke() {
        val albums = albumRepository.loadAlbums()
        Timber.d("albums $albums")
    }

}