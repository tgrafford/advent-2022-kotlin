package se.grafford.advent2022

class Day03(val input: List<String>) {

    val priorities: Map<Char, Int> = (('a'..'z') + ('A'..'Z')).withIndex().associateBy({ it.value }) { it.index + 1 }

    fun solvePart1(): Int = input
        .map { it.toCharArray().toList() }
        .map { it.chunked(it.size / 2) }
        .flatMap { (c1, c2) -> c1 intersect c2 }
        .sumOf { priorities[it] ?: 0 }

    fun solvePart2(): Int = input
        .map { it.toCharArray().toSet() }
        .chunked(3)
        .flatMap { it.reduce { prev, curr -> prev intersect curr } }
        .sumOf { priorities[it] ?: 0 }
}