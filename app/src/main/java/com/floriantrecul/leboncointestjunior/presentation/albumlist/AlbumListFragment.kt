package com.floriantrecul.leboncointestjunior.presentation.albumlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.floriantrecul.leboncointestjunior.databinding.FragmentAlbumListBinding
import com.floriantrecul.leboncointestjunior.presentation.BaseFragment
import com.floriantrecul.leboncointestjunior.util.hide
import com.floriantrecul.leboncointestjunior.util.observeInLifecycle
import com.floriantrecul.leboncointestjunior.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class AlbumListFragment : BaseFragment<FragmentAlbumListBinding, AlbumListViewModel>() {

    override val viewModel: AlbumListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        subscribeToCollects()
    }

    private fun subscribeToCollects() = with(binding) {
        viewModel.onEvent(AlbumListEvent.LoadAlbums)

        viewModel.state
            .onEach { state ->
                when (state) {
                    is AlbumListState.Loading -> progressBarAlbumList.show()
                    is AlbumListState.Success -> {
                        progressBarAlbumList.hide()
                        Timber.d("albums ${state.albums}")
                    }
                    is AlbumListState.Error -> progressBarAlbumList.hide()
                    else -> Unit
                }
            }
            .observeInLifecycle(viewLifecycleOwner)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAlbumListBinding.inflate(inflater, container, false)

}