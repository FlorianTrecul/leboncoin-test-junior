package com.floriantrecul.leboncointestjunior.domain.repository

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.util.Resource
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    /**
     * This function load albums
     * @return Flow<Resource<List<AlbumEntity>>> is a flow of type list AlbumEntity
     */
    suspend fun loadAlbums(): Flow<Resource<List<AlbumEntity>>>
}