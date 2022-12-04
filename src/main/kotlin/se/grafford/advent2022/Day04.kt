package se.grafford.advent2022

class Day04(val input: List<String>) {

    fun solvePart1(): Int = input
        .map(::assignmentPairs)
        .count { (first, second) -> (first intersect second).let { it == first || it == second } }

    fun solvePart2(): Int = input
        .map(::assignmentPairs)
        .count { (first, second) -> (first intersect second).isNotEmpty() }

    private fun assignmentPairs(pairs: String) = pairs
        .split(",")
        .map(::sections)

    private fun sections(section: String) = section
        .split("-")
        .let { (first, second) -> IntRange(first.toInt(), second.toInt()).toSet() }
}