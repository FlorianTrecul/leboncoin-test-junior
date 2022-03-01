package com.floriantrecul.leboncointestjunior.data.data_source.remote.mapper

import com.floriantrecul.leboncointestjunior.data.data_source.remote.dto.AlbumDto
import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.data.mapper.Mapper

class AlbumDtoMapper : Mapper<AlbumEntity, AlbumDto> {

    override fun mapFromEntity(type: AlbumEntity): AlbumDto {
        return AlbumDto(
            albumId = type.albumId,
            id = type.id,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }

    override fun mapToEntity(type: AlbumDto): AlbumEntity {
        return AlbumEntity(
            albumId = type.albumId,
            id = type.id,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }
}