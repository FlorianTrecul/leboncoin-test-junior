package com.floriantrecul.leboncointestjunior.domain.repository

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.util.Resource
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    suspend fun loadAlbums(): Flow<Resource<List<AlbumEntity>>>
}