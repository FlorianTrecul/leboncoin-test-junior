package com.floriantrecul.leboncointestjunior.data.data_source.remote.service

import com.floriantrecul.leboncointestjunior.data.data_source.remote.dto.AlbumDto
import retrofit2.http.GET


interface ApiService {

    /**
     * This function load albums from api
     * @return List<AlbumDto> is a list AlbumDto
     */
    @GET("/img/shared/technical-test.json")
    suspend fun getAlbums() : List<AlbumDto>

}