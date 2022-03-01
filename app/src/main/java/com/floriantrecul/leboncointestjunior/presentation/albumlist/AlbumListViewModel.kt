package com.floriantrecul.leboncointestjunior.presentation.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.floriantrecul.leboncointestjunior.R
import com.floriantrecul.leboncointestjunior.data.mapper.AlbumMapper
import com.floriantrecul.leboncointestjunior.domain.use_case.AlbumUseCases
import com.floriantrecul.leboncointestjunior.presentation.albumlist.AlbumListViewModel.AlbumListUiEvent.ShowSnackbarUiMessage
import com.floriantrecul.leboncointestjunior.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val albumsUseCase: AlbumUseCases,
    private val albumMapper: AlbumMapper
) : ViewModel() {

    private val _albumListFlowEvent = MutableSharedFlow<AlbumListUiEvent>()
    val albumListFlowEvent = _albumListFlowEvent.asSharedFlow()

    private val _state = MutableStateFlow<AlbumListState>(AlbumListState.Empty)
    val state = _state.asStateFlow()

    /**
     * This function loads the state of the album resource from the LoadAlbumUseCase use case
     */
    private fun loadAlbums() = viewModelScope.launch(Dispatchers.IO) {
        albumsUseCase.loadAlbums()
            .onEach { albumsState ->
                when (albumsState) {
                    is Resource.Empty -> _state.value = AlbumListState.Empty
                    is Resource.Loading -> _state.value = AlbumListState.Loading
                    is Resource.Success -> {
                        val albums = albumsState.data.map { albumEntity ->
                            albumMapper.mapFromEntity(albumEntity)
                        }
                        _state.value = AlbumListState.Success(albums)
                    }
                    is Resource.Error -> {
                        _state.value = AlbumListState.Error
                        onShowSnackbarUiMessage(
                            albumsState.message ?: R.string.error_message_info_unknown,
                            R.string.retry
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    /**
     * This function handle the user's event
     * @param event is an AlbumListEvent to handle the user's event
     */
    fun onEvent(event: AlbumListEvent) {
        when (event) {
            is AlbumListEvent.LoadAlbums -> loadAlbums()
        }
    }

    private fun onShowSnackbarUiMessage(message: Int, action: Int) = viewModelScope.launch {
        _albumListFlowEvent.emit(ShowSnackbarUiMessage(message, action))
    }

    sealed class AlbumListUiEvent {
        data class ShowSnackbarUiMessage(val message: Int, val action: Int) : AlbumListUiEvent()
    }
}