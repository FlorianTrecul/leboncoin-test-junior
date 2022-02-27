package com.floriantrecul.leboncointestjunior.presentation.albumlist

sealed class AlbumListEvent {
    object LoadAlbums : AlbumListEvent()
}