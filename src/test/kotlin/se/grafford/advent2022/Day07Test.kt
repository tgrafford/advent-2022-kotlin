package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day07Test : ShouldSpec({

    val example = """
        ${'$'} cd /
        ${'$'} ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        ${'$'} cd a
        ${'$'} ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        ${'$'} cd e
        ${'$'} ls
        584 i
        ${'$'} cd ..
        ${'$'} cd ..
        ${'$'} cd d
        ${'$'} ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day07(example).solvePart1() shouldBe 95437
        }

        should("solve the answer") {
            Day07(readResourceLines("day07.txt")).solvePart1() shouldBe 1350966
        }
    }

    context("Part 2") {
        should("match example") {
            Day07(example).solvePart2() shouldBe 24933642
        }

        should("solve the answer") {
            Day07(readResourceLines("day07.txt")).solvePart2() shouldBe 6296435
        }
    }
})