package second

fun main(args: Array<String>) {
    val count = readln().toInt()

    val coordinates = mutableListOf<Pair<Int, Int>>()
    for (i in 1..count) {
        val list = readln().split(" ")
        coordinates.add(Pair(list.first().toInt(), list.last().toInt()))
    }

    var minX = coordinates.first().first
    var minY = coordinates.first().second
    var maxX = coordinates.first().first
    var maxY = coordinates.first().second

    for (coordinate in coordinates) {
        if (coordinate.first < minX) minX = coordinate.first
        if (coordinate.first > maxX) maxX = coordinate.first
        if (coordinate.second < minY) minY = coordinate.second
        if (coordinate.second > maxY) maxY = coordinate.second
    }

    println(listOf(minX, minY, maxX, maxY).joinToString(" "))
}