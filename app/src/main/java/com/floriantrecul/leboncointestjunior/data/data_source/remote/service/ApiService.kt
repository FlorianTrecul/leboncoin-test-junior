package com.floriantrecul.leboncointestjunior.data.data_source.remote.service

import com.floriantrecul.leboncointestjunior.data.data_source.remote.dto.AlbumDto
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("/img/shared/technical-test.json")
    suspend fun getAlbums() : List<AlbumDto>

}