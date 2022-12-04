package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day04Test : ShouldSpec({

    val example = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day04(example).solvePart1() shouldBe 2
        }

        should("solve the answer") {
            Day04(readResource("day04.txt")).solvePart1() shouldBe 644
        }
    }

    context("Part 2") {
        should("match example") {
            Day04(example).solvePart2() shouldBe 4
        }

        should("solve the answer") {
            Day04(readResource("day04.txt")).solvePart2() shouldBe 926
        }
    }
})