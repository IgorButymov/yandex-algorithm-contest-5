package second

fun main(args: Array<String>) {
    val n = readln().toInt()

    val coordinates = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val list = readln().split(" ")
        coordinates.add(Pair(list.first().toInt(), list.last().toInt()))
    }

    val board = MutableList(10) { MutableList(10) { 0 } }

    for (coordinate in coordinates) {
        board[coordinate.first][coordinate.second] = 1
    }

    var res = coordinates.size * 4

    for (coordinate in coordinates) {
        val shiftListX = listOf(coordinate.first, coordinate.first + 1, coordinate.first, coordinate.first - 1)
        val shiftListY = listOf(coordinate.second - 1, coordinate.second, coordinate.second + 1, coordinate.second)

        for (i in 0..3) {
            if (board[shiftListX[i]][shiftListY[i]] == 1) res -= 1
        }
    }

    println(res)
}
