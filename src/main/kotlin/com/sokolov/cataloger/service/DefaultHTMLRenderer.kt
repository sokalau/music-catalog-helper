package com.sokolov.cataloger.service

import com.sokolov.cataloger.model.Song

class DefaultHTMLRenderer : HTMLRenderer {
    companion object {
        private const val EMPTY = ""
    }

    override fun render(songs: List<Song>): String {
        return songs.joinToString(separator = EMPTY) { "<p>${it.title}</p>" }
    }
}