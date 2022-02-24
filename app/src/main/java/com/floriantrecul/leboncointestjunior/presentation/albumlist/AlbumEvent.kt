package com.floriantrecul.leboncointestjunior.presentation.albumlist

sealed class AlbumEvent {
    object LoadAlbums : AlbumEvent()
}