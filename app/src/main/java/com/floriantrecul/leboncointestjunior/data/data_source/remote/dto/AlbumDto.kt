package com.floriantrecul.leboncointestjunior.data.data_source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDto(
    @Json(name = "albumId")
    val albumId: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String
)
