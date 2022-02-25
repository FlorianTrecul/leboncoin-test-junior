package com.floriantrecul.leboncointestjunior.data.respository

import com.floriantrecul.leboncointestjunior.R
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
            return Resource.Error(R.string.error_message_title_unknown, R.string.error_message_info_unknown)
        }
        return Resource.Success(response.map { albumDto ->
            albumDtoMapper.mapFromEntity(albumDto)
        })
    }
}