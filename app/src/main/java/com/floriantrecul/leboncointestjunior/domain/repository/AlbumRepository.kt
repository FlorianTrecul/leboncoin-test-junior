package com.floriantrecul.leboncointestjunior.domain.repository

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.util.Resource

interface AlbumRepository {

    suspend fun loadAlbums(): Resource<List<AlbumEntity>>
}