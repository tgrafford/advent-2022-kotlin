package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day02Test : ShouldSpec({

    val example = """
        A Y
        B X
        C Z
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day02(example).solvePart1() shouldBe 15
        }

        should("solve the answer") {
            Day02(readResourceLines("day02.txt")).solvePart1() shouldBe 13446
        }
    }

    context("Part 2") {
        should("match example") {
            Day02(example).solvePart2() shouldBe 12
        }

        should("solve the answer") {
            Day02(readResourceLines("day02.txt")).solvePart2() shouldBe 13509
        }
    }
})