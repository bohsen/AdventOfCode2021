fun main() {
    fun part1(input: List<String>): Int {
        val forwards = input.filter { it.contains("forward ") }.map { it.removePrefix("forward ").toInt() }
        val ups = input.filter { it.contains("up ") }.map { it.removePrefix("up ").toInt() }
        val downs = input.filter { it.contains("down ") }.map { it.removePrefix("down ").toInt() }

        val horizontal = forwards.sum()
        val depth = downs.sum() - ups.sum()
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for(line in input) {
            val s = line.split(" ")
            val value = s[1].toInt()
            when(s[0]) {
                "forward" -> {
                    horizontal += value
                    depth += aim*value
                }
                "up" -> { aim -= value }
                "down" -> { aim += value }
            }
        }
        return horizontal*depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
