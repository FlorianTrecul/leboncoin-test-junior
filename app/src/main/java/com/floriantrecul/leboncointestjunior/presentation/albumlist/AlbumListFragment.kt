package com.floriantrecul.leboncointestjunior.presentation.albumlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.floriantrecul.leboncointestjunior.databinding.FragmentAlbumListBinding
import com.floriantrecul.leboncointestjunior.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumListFragment : BaseFragment<FragmentAlbumListBinding, AlbumListViewModel>() {

    override val viewModel: AlbumListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEvent(AlbumEvent.LoadAlbums)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAlbumListBinding.inflate(inflater, container, false)

}