package com.sokolov.musiccataloghelper.service

import com.sokolov.musiccataloghelper.model.Song
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.Parser
import org.apache.tika.parser.mp3.Mp3Parser
import org.xml.sax.ContentHandler
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

class DefaultMP3Parser : MP3Parser {
    companion object {
        private const val TITLE = "title"
        private const val ARTIST = "xmpDM:artist"
        private const val COMPOSER = "xmpDM:composer"
        private const val GENRE = "xmpDM:genre"
        private const val ALBUM = "xmpDM:album"
        private const val DURATION = "xmpDM:duration"
    }

    private val handler: ContentHandler = DefaultHandler()
    private val metadata = Metadata()
    private val parser: Parser = Mp3Parser()
    private val context = ParseContext()

    override fun parseDirectory(directory: File?): List<Song> {
        val songs = mutableListOf<Song>()

        directory?.apply {
            if (directory.exists() && directory.isDirectory) {
                val files = directory.listFiles()?.toMutableList()

                files?.parallelStream()?.forEach { file: File ->
                    if (file.isDirectory) {
                        songs.addAll(parseDirectory(file))
                    } else if (file.isFile) {
                        songs.add(parseSong(file))
                    }
                }
            }
        }

        return songs
    }

    private fun parseSong(mp3: File): Song {
        val inputStream: InputStream = FileInputStream(mp3)
        parser.parse(inputStream, handler, metadata, context)
        inputStream.close()

        return Song(
            title = metadata[TITLE], artist = metadata[ARTIST], composer = metadata[COMPOSER],
            genre = metadata[GENRE], album = metadata[ALBUM], duration = metadata[DURATION],
            path = mp3.path
        )
    }
}