package com.floriantrecul.leboncointestjunior.data.mapper

import com.floriantrecul.leboncointestjunior.data.entities.AlbumEntity
import com.floriantrecul.leboncointestjunior.domain.model.Album

class AlbumMapper: Mapper<AlbumEntity, Album> {

    override fun mapFromEntity(type: AlbumEntity): Album {
        return Album(
            albumId = type.albumId,
            id = type.id,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }

    override fun mapToEntity(type: Album): AlbumEntity {
        return AlbumEntity(
            albumId = type.albumId,
            id = type.id,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }
}