package com.floriantrecul.leboncointestjunior.presentation.albumlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.floriantrecul.leboncointestjunior.databinding.ItemAlbumBinding
import com.floriantrecul.leboncointestjunior.domain.model.Album

class AlbumListAdapter : ListAdapter<Album, AlbumListAdapter.AlbumListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListViewHolder {
        return AlbumListViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumListViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album!!)
    }

    inner class AlbumListViewHolder(
        private val binding: ItemAlbumBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {

            binding.apply {
                imageItemAlbum.load(album.thumbnailUrl)
                titleItemAlbum.text = album.title
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Album>() {

        override fun areItemsTheSame(oldItem: Album, newItem: Album) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Album, newItem: Album) = oldItem == newItem

    }

}