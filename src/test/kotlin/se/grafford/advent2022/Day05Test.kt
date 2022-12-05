package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day05Test : ShouldSpec({

    val example = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2        
    """.trimIndent()

    context("Part 1") {
        should("match example") {
            Day05(example).solvePart1() shouldBe "CMZ"
        }

        should("solve the answer") {
            Day05(readResource("day05.txt")).solvePart1() shouldBe "TLNGFGMFN"
        }
    }

    context("Part 2") {
        should("match example") {
            Day05(example).solvePart2() shouldBe "MCD"
        }

        should("solve the answer") {
            Day05(readResource("day05.txt")).solvePart2() shouldBe "FGLQJCMBD"
        }
    }
})