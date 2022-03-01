package com.floriantrecul.leboncointestjunior.data.respository

import com.floriantrecul.leboncointestjunior.R
import com.floriantrecul.leboncointestjunior.data.data_source.remote.mapper.AlbumDtoMapper
import com.floriantrecul.leboncointestjunior.data.data_source.remote.service.ApiService
import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.domain.repository.AlbumRepository
import com.floriantrecul.leboncointestjunior.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val albumDtoMapper: AlbumDtoMapper
) : AlbumRepository {

    override suspend fun loadAlbums(): Flow<Resource<List<AlbumEntity>>> = flow {
        emit(Resource.Loading)
        try {
            val albumsDto = apiService.getAlbums()
            emit(
                Resource.Success(
                    albumsDto.map { albumDto ->
                        albumDtoMapper.mapToEntity(albumDto)
                    }
                )
            )
        } catch (e: Exception) {
            val error = when (e) {
                is UnknownHostException -> Resource.Error(
                    R.string.error_message_title_no_network,
                    R.string.error_message_info_no_network
                )
                is HttpException -> Resource.Error(
                    R.string.error_message_title_no_load,
                    R.string.error_message_info_no_load
                )
                else -> Resource.Error(
                    R.string.error_message_title_unknown,
                    R.string.error_message_info_unknown
                )
            }
            emit(error)
        }
    }
}