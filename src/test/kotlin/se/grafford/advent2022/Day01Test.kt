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
        should("matches example") {
            Day01(example).solvePart1() shouldBe 24000
        }

        should("solves the answer") {
            Day01(readResourceLines("day01.txt")).solvePart1() shouldBe 69626
        }
    }

    context("Part 2") {
        should("matches example") {
            Day01(example).solvePart2() shouldBe 45000
        }

        should("solves the answer") {
            Day01(readResourceLines("day01.txt")).solvePart2() shouldBe 206780
        }
    }
})