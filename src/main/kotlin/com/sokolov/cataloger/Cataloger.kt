package com.sokolov.cataloger

import com.sokolov.cataloger.model.Song
import com.sokolov.cataloger.service.Benchmark
import com.sokolov.cataloger.service.DefaultHTMLRenderer
import com.sokolov.cataloger.service.DefaultMP3Parser
import java.io.File

fun main() {
    val parser = DefaultMP3Parser()
    val directory = File("C:\\Users\\Nikita\\Downloads\\Bring Me The Horizon")
    var songs = emptyList<Song>()

    val parsingTime = Benchmark.evaluate {
        songs = parser.parseDirectory(directory)
    }

    println(parsingTime)

    val renderer = DefaultHTMLRenderer()
    var html = ""

    val renderingTime = Benchmark.evaluate {
        html = renderer.render(songs)
    }

    println(renderingTime)

    File("C:\\Users\\Nikita\\Downloads\\Bring Me The Horizon\\index.html").writeText(html)
}