package com.sokolov.musiccataloghelper.service

import java.time.Duration
import java.time.Instant

object Benchmark {
    fun evaluate(body: () -> Unit): Long {
        val start = Instant.now()
        try {
            body()
        } finally {
            val end = Instant.now()
            return Duration.between(start, end).toMillis()
        }
    }
}