package se.grafford.advent2022

inline fun <T> MutableList<T>.getOrAdd(index: Int, defaultValue: (Int) -> T): T {
    return if (index in 0..lastIndex) get(index) else defaultValue(index).also { add(it) }
}

inline fun <T> Iterable<T>.lcmOf(selector: (T) -> Long): Long {
    val iter = iterator()
    var res = if (iter.hasNext()) selector(iter.next()) else return 0
    while (iter.hasNext()) {
        val next = selector(iter.next())
        res = lcm(res, next)
    }
    return res
}