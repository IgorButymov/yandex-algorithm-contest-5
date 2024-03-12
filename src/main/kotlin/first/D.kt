package first

fun main(args: Array<String>) {
    val row1 = readLine()!!.split("").subList(1, 9)
    val row2 = readLine()!!.split("").subList(1, 9)
    val row3 = readLine()!!.split("").subList(1, 9)
    val row4 = readLine()!!.split("").subList(1, 9)
    val row5 = readLine()!!.split("").subList(1, 9)
    val row6 = readLine()!!.split("").subList(1, 9)
    val row7 = readLine()!!.split("").subList(1, 9)
    val row8 = readLine()!!.split("").subList(1, 9)

    val board = mutableListOf<List<String>>()

    board.add(row1)
    board.add(row2)
    board.add(row3)
    board.add(row4)
    board.add(row5)
    board.add(row6)
    board.add(row7)
    board.add(row8)

//    for (row in board) {
//        for (char in row) {
//            print(char)
//        }
//        println()
//    }

    val set = mutableSetOf<Pair<Int, Int>>()

    board.forEachIndexed { index1, row ->
        row.forEachIndexed { index2, element ->
            if (element == "R") {
                var tempIndex1 = index1
                var tempIndex2 = index2
                var tempElement = ""
                // бежим по горизонтали
                while (tempIndex2 != -1 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(index1, tempIndex2))
                    tempIndex2--
                    if (tempIndex2 != -1) tempElement = board[index1][tempIndex2]
                }
                tempIndex2 = index2
                tempElement = ""
                while (tempIndex2 != 8 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(index1, tempIndex2))
                    tempIndex2++
                    if (tempIndex2 != 8) tempElement = board[index1][tempIndex2]
                }
                tempElement = ""
                // бежим по вертикали
                while (tempIndex1 != -1 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, index2))
                    tempIndex1--
                    if (tempIndex1 != -1) tempElement = board[tempIndex1][index2]
                }
                tempElement = ""
                tempIndex1 = index1
                while (tempIndex1 != 8 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, index2))
                    tempIndex1++
                    if (tempIndex1 != 8) tempElement = board[tempIndex1][index2]
                }

                set.add(Pair(index1, index2))
            }

            if (element == "B") {
                var tempIndex1 = index1
                var tempIndex2 = index2
                var tempElement = ""
                // бежим левой диагонали
                while (tempIndex2 != -1 && tempIndex1 != -1 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, tempIndex2))
                    tempIndex1--
                    tempIndex2--
                    if (tempIndex2 != -1 && tempIndex1 != -1) tempElement = board[tempIndex1][tempIndex2]
                }
                tempIndex1 = index1
                tempIndex2 = index2
                tempElement = ""
                while (tempIndex2 != 8 && tempIndex1 != 8 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, tempIndex2))
                    tempIndex1++
                    tempIndex2++
                    if (tempIndex2 != 8 && tempIndex1 != 8) tempElement = board[tempIndex1][tempIndex2]
                }
                tempIndex1 = index1
                tempIndex2 = index2
                tempElement = ""
                // бежим правой диагонали
                while (tempIndex1 != 8 && tempIndex2 != -1 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, tempIndex2))
                    tempIndex1++
                    tempIndex2--
                    if (tempIndex1 != 8 && tempIndex2 != -1) tempElement = board[tempIndex1][tempIndex2]
                }
                tempIndex1 = index1
                tempIndex2 = index2
                tempElement = ""
                while (tempIndex1 != -1 && tempIndex2 != 8 && tempElement != "R" && tempElement != "B") {
                    set.add(Pair(tempIndex1, tempIndex2))
                    tempIndex1--
                    tempIndex2++
                    if (tempIndex1 != -1 && tempIndex2 != 8) tempElement = board[tempIndex1][tempIndex2]
                }

                set.add(Pair(index1, index2))
            }
        }
    }

    println(64 - set.size)
}