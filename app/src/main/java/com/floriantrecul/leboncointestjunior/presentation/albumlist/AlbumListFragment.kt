package com.floriantrecul.leboncointestjunior.presentation.albumlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.floriantrecul.leboncointestjunior.R
import com.floriantrecul.leboncointestjunior.databinding.FragmentAlbumListBinding
import com.floriantrecul.leboncointestjunior.presentation.BaseFragment
import com.floriantrecul.leboncointestjunior.util.hide
import com.floriantrecul.leboncointestjunior.util.observeInLifecycle
import com.floriantrecul.leboncointestjunior.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class AlbumListFragment : BaseFragment<FragmentAlbumListBinding, AlbumListViewModel>() {

    override val viewModel: AlbumListViewModel by viewModels()

    private lateinit var albumListAdapter: AlbumListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.album_list_toolbar_title)

        setupUi()
    }

    private fun setupUi() {
        subscribeToCollects()
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding) {
        albumListAdapter = AlbumListAdapter()
        recyclerViewAlbumList.apply {
            adapter = albumListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun subscribeToCollects() = with(binding) {
        viewModel.onEvent(AlbumListEvent.LoadAlbums)

        viewModel.state
            .onEach { state ->
                when (state) {
                    is AlbumListState.Loading -> loadGroupAlbumList.show()
                    is AlbumListState.Success -> {
                        loadGroupAlbumList.hide()
                        albumListAdapter.submitList(state.albums)
                    }
                    is AlbumListState.Error -> loadGroupAlbumList.hide()
                    else -> Unit
                }
            }
            .observeInLifecycle(viewLifecycleOwner)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAlbumListBinding.inflate(inflater, container, false)

}