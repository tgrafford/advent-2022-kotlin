package se.grafford.advent2022

import java.io.BufferedReader

fun readResourceLines(fileName: String): List<String> = resourceAsReader(fileName).readLines()

fun readResource(fileName: String): String = resourceAsReader(fileName).readText()

fun resourceAsReader(fileName: String): BufferedReader =
    Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)?.bufferedReader()
        ?: error("Cannot find resource: $fileName")