package se.grafford.advent2022

class Day05(val input: String) {

    fun solvePart1(): String {
        val (stacks, steps) = getStacksAndSteps()
        steps.forEach { (amount, from, to) ->
            for (move in 0 until amount) {
                stacks[to].addFirst(stacks[from].removeFirst())
            }
        }
        return stacks.mapNotNull { it.firstOrNull() }.joinToString("")
    }

    fun solvePart2(): String {
        val (stacks, steps) = getStacksAndSteps()
        steps.forEach { (amount, from, to) ->
            val fromStack = stacks[from]
            (1..amount).map { fromStack.removeFirst() }.reversed().forEach(stacks[to]::addFirst)
        }
        return stacks.mapNotNull { it.firstOrNull() }.joinToString("")
    }

    private fun getStacksAndSteps() = input
        .split("\n\n")
        .let { getStacks(it[0]) to getSteps(it[1]) }

    private fun getStacks(stacksOfCrates: String): List<ArrayDeque<Char>> = stacksOfCrates
        .lines()
        .dropLast(1)
        .map { it.filterIndexed { i, _ -> i % 4 == 1 } }
        .fold(mutableListOf()) { acc, crates ->
            acc.apply {
                crates.forEachIndexed { i, c ->
                    getOrAdd(i) { ArrayDeque() }.takeIf { c in 'A'..'Z' }?.addLast(c)
                }
            }
        }

    private fun getSteps(procedure: String) = procedure
        .lines()
        .map { it.split(" ").filterIndexed { i, s -> i % 2 == 1 && s.isNotBlank() }.map(String::toInt) }
        .map { listOf(it[0], it[1] - 1, it[2] - 1) }
}