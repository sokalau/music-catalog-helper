package com.sokolov.cataloger.service

import com.sokolov.cataloger.model.Song
import java.io.File

interface MP3Parser {
    fun parseDirectory(directory: File?): List<Song>
}