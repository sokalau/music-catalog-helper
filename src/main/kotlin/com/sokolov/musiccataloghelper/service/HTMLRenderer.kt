package com.sokolov.musiccataloghelper.service

import com.sokolov.musiccataloghelper.model.Song

interface HTMLRenderer {
    fun render(songs: List<Song>): String
}