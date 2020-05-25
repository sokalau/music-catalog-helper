package com.sokolov.musiccataloghelper.model

data class Song(
    val title: String? = UNKNOWN,
    val artist: String? = UNKNOWN,
    val composer: String? = UNKNOWN,
    val genre: String? = UNKNOWN,
    val album: String? = UNKNOWN,
    val duration: String? = UNKNOWN,
    val path: String? = UNKNOWN
) {
    companion object {
        private const val UNKNOWN = "unknown"
    }
}
