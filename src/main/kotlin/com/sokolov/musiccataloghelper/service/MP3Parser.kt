package com.sokolov.musiccataloghelper.service

import com.sokolov.musiccataloghelper.model.Song
import java.io.File

interface MP3Parser {
    fun parseDirectory(directory: File?): List<Song>
}