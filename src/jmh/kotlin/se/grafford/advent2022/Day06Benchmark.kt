package se.grafford.advent2022

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class Day06Benchmark {

    val input = readResource("day06.txt")
    val day06 = Day06(input)
    val day06Optimized = Day06Optimized(input)

    @Benchmark
    fun part1(blackhole: Blackhole) {
        blackhole.consume(day06.solvePart1())
    }

    @Benchmark
    fun part2(blackhole: Blackhole) {
        blackhole.consume(day06.solvePart2())
    }

    @Benchmark
    fun part1Optimized(blackhole: Blackhole) {
        blackhole.consume(day06Optimized.solvePart1())
    }

    @Benchmark
    fun part2Optimized(blackhole: Blackhole) {
        blackhole.consume(day06Optimized.solvePart2())
    }
}