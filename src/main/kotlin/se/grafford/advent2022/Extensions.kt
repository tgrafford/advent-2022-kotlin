package se.grafford.advent2022

inline fun <T> MutableList<T>.getOrAdd(index: Int, defaultValue: (Int) -> T): T {
    return if (index in 0..lastIndex) get(index) else defaultValue(index).also { add(it) }
}