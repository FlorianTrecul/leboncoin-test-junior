package com.floriantrecul.leboncointestjunior.presentation.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.floriantrecul.leboncointestjunior.data.mapper.AlbumMapper
import com.floriantrecul.leboncointestjunior.domain.use_case.AlbumUseCases
import com.floriantrecul.leboncointestjunior.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val albumsUseCase: AlbumUseCases,
    private val albumMapper: AlbumMapper
) : ViewModel() {

    private val _state = MutableStateFlow<AlbumListState>(AlbumListState.Loading)
    val state = _state.asStateFlow()

    private fun loadAlbums() = viewModelScope.launch(Dispatchers.IO) {
        when (albumsUseCase.loadAlbums()) {
            is Resource.Empty -> _state.value = AlbumListState.Empty
            is Resource.Loading -> _state.value = AlbumListState.Loading
            is Resource.Success -> {
                if (albumsUseCase.loadAlbums().extractData != null) {
                    val albums = albumsUseCase.loadAlbums().extractData!!.map { albumEntity ->
                        albumMapper.mapFromEntity(albumEntity)
                    }
                    _state.value = AlbumListState.Success(albums)
                }
            }
            is Resource.Error -> _state.value = AlbumListState.Error
        }
    }

    fun onEvent(event: AlbumListEvent) {
        when (event) {
            is AlbumListEvent.LoadAlbums -> loadAlbums()
        }
    }
}