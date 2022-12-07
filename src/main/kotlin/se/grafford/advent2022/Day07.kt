package se.grafford.advent2022

class Day07(val input: List<String>) {

    companion object {
        const val root = "/"
        const val prev = ".."
        const val totalSpace = 70000000
        const val requiredSpace = 30000000
    }

    fun solvePart1(): Int = input
        .mapNotNull(::parseCmd)
        .fold(Directory(null, root)) { pwd, cmd -> cmd.execute(pwd) }
        .let { ChangeDirectory(root).execute(it) }
        .filterIsInstance<Directory>()
        .map { it.size() }
        .filter { it <= 100000 }
        .sum()

    fun solvePart2(): Int = input
        .mapNotNull(::parseCmd)
        .fold(Directory(null, root)) { pwd, cmd -> cmd.execute(pwd) }
        .let { ChangeDirectory(root).execute(it) }
        .let { root ->
            val maxUsed = totalSpace - requiredSpace
            val needToFree = root.size() - maxUsed
            root.filterIsInstance<Directory>().filter { it.size() >= needToFree }.minOf { it.size() }
        }

    private fun parseCmd(line: String): Command? = when {
        line.startsWith("$ cd") -> ChangeDirectory(line.substring(5))
        line.startsWith("dir") -> AddDirectory(line.substring(4))
        !line.startsWith("$") -> line.split(" ").let { AddFile(it[1], it[0].toInt()) }
        else -> null
    }

    sealed class Command {
        abstract fun execute(pwd: Directory): Directory
    }

    class ChangeDirectory(private val name: String) : Command() {
        override fun execute(pwd: Directory): Directory = when (name) {
            prev -> pwd.parent!!
            root -> getRoot(pwd)
            else -> pwd.children.filterIsInstance<Directory>().first { it.name == name }
        }

        override fun toString(): String = "$ cd $name"

        private fun getRoot(dir: Directory): Directory =
            if (dir.parent == null) dir else getRoot(dir.parent)
    }

    class AddDirectory(val name: String) : Command() {
        override fun execute(pwd: Directory): Directory = pwd.addDirectory(name)

        override fun toString(): String = "AddDirectory(name=$name)"
    }

    class AddFile(val name: String, val size: Int) : Command() {
        override fun execute(pwd: Directory): Directory = pwd.addFile(name, size)

        override fun toString(): String = "AddFile(name=$name, size=$size)"
    }

    sealed class Node(val parent: Directory?, val name: String) {
        abstract fun size(): Int
    }

    class File(parent: Directory, name: String, val size: Int) : Node(parent, name) {
        override fun size(): Int = size

        override fun toString(): String = "$name (file, size=$size)"
    }

    class Directory(parent: Directory?, name: String) : Node(parent, name), Iterable<Node> {
        val children = mutableListOf<Node>()

        override fun size(): Int = children.sumOf { it.size() }

        override fun iterator(): Iterator<Node> = iterator {
            yield(this@Directory)
            children.forEach {
                when (it) {
                    is File -> yield(it)
                    is Directory -> yieldAll(it.iterator())
                }
            }
        }

        fun addDirectory(name: String): Directory = addNode(Directory(this, name))
        fun addFile(name: String, size: Int): Directory = addNode(File(this, name, size))

        private fun addNode(n: Node): Directory = apply { children.add(n) }

        override fun toString(): String = "$name (dir)"
    }
}