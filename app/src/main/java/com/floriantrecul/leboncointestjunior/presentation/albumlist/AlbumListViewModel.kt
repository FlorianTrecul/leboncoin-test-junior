package com.floriantrecul.leboncointestjunior.presentation.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.floriantrecul.leboncointestjunior.domain.use_case.AlbumUseCases
import com.floriantrecul.leboncointestjunior.domain.use_case.LoadAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val albumsUseCase: AlbumUseCases
): ViewModel() {

    private fun loadAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            albumsUseCase.loadAlbums()
        }
    }

    fun onEvent(event: AlbumEvent) {
        when (event) {
            is AlbumEvent.LoadAlbums -> loadAlbums()
        }
    }
}