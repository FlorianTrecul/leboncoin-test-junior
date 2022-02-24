package com.floriantrecul.leboncointestjunior.data.respository

import com.floriantrecul.leboncointestjunior.data.data_source.remote.mapper.AlbumDtoMapper
import com.floriantrecul.leboncointestjunior.data.data_source.remote.service.ApiService
import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import com.floriantrecul.leboncointestjunior.util.Resource
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val albumDtoMapper: AlbumDtoMapper
) : AlbumRepository {

    override suspend fun loadAlbums(): Resource<List<AlbumEntity>> {
        val response = try {
            apiService.getAlbums()
        } catch (e: Exception) {
            return Resource.Error(0, 0)
        }
        return Resource.Success(response.map { albumDto ->
            albumDtoMapper.mapFromEntity(albumDto)
        })
    }
}