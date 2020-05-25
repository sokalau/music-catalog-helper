package com.sokolov.cataloger.service

import com.sokolov.cataloger.model.Song

interface HTMLRenderer {
    fun render(songs: List<Song>): String
}