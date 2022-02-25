package com.floriantrecul.leboncointestjunior.presentation.albumlist

import com.floriantrecul.leboncointestjunior.domain.model.Album

sealed class AlbumListState {
    object Empty: AlbumListState()
    object Loading: AlbumListState()
    data class Success(val albums: List<Album>) : AlbumListState()
    object Error: AlbumListState()
}
