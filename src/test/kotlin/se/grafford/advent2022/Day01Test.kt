package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day01Test : ShouldSpec({

    val example = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day01(example).solvePart1() shouldBe 24000
        }

        should("solve the actual answer") {
            Day01(readResource("day01.txt")).solvePart1() shouldBe 69626
        }
    }

    context("Part 2") {
        should("match example") {
            Day01(example).solvePart2() shouldBe 45000
        }

        should("solve the actual answer") {
            Day01(readResource("day01.txt")).solvePart2() shouldBe 206780
        }
    }
})