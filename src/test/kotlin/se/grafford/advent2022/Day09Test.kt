package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day09Test : ShouldSpec({

    val example1 = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent().lines()

    val example2 = """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day09(example1).solvePart1() shouldBe 13
        }

        should("solve the answer") {
            Day09(readResourceLines("day09.txt")).solvePart1() shouldBe 6057
        }
    }

    context("Part 2") {
        should("match example") {
            Day09(example2).solvePart2() shouldBe 36
        }

        should("solve the answer") {
            Day09(readResourceLines("day09.txt")).solvePart2() shouldBe 2514
        }
    }
})