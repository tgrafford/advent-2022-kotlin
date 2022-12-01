package se.grafford.advent2022

fun readResource(fileName: String): List<String> =
    Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)?.bufferedReader()?.readLines()
        ?: error("Cannot find resource: $fileName")