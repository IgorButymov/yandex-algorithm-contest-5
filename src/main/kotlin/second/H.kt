package second

fun main(args: Array<String>) {
    val firstRow = readln().split(" ").map { it.toInt() }

    val raceCount = firstRow[0]
    val classCount = firstRow[1]

    val field = mutableListOf<List<Int>>()

    for (i in 1..raceCount) {
        field.add(readln().split(" ").map { it.toInt() })
    }

    var max1 = 0
    var max1Index = Pair(0, 0)

    field.forEachIndexed { index1, row ->
        row.forEachIndexed { index2, elem ->
            if (elem > max1) {
                max1 = elem
                max1Index = Pair(index1, index2)
            }
        }
    }

    var max2 = 0
    var max2Index = Pair(0, 0)

    field.forEachIndexed { index1, row ->
        row.forEachIndexed { index2, elem ->
            if (elem > max2 && Pair(index1, index2) != max1Index) {
                max2 = elem
                max2Index = Pair(index1, index2)
            }
        }
    }

    var max1Race = 0

    for (i in 0..classCount - 1) {
        val elem = field[max1Index.first][i]
        if (elem > max1Race && Pair(max1Index.first, i) != max1Index) max1Race = elem
    }

    var max1Class = 0

    for (i in 0..raceCount - 1) {
        val elem = field[i][max1Index.second]
        if (elem > max1Class && Pair(i, max1Index.second) != max1Index) max1Class = elem
    }

    var max2Race = 0

    for (i in 0..classCount - 1) {
        val elem = field[max2Index.first][i]
        if (elem > max2Race && Pair(max2Index.first, i) != max2Index) max2Race = elem
    }

    var max2Class = 0

    for (i in 0..raceCount - 1) {
        val elem = field[i][max2Index.second]
        if (elem > max2Class && Pair(i, max2Index.second) != max2Index) max2Class = elem
    }

    val list = listOf(max1Race, max1Class, max2Race, max2Class)
    var maxList = 0
    var maxListIndex = 0

    list.forEachIndexed { index, elem ->
        if (elem > maxList) {
            maxList = elem
            maxListIndex = index
        }
    }

    if (maxListIndex == 0) { // 1Race
        var max22 = 0
        var max22Index = Pair(0, 0)

        field.forEachIndexed { index1, row ->
            row.forEachIndexed { index2, elem ->
                if (index1 != max1Index.first && elem > max22) {
                    max22 = elem
                    max22Index = Pair(index1, index2)
                }
            }
        }

        println("${max1Index.first + 1} ${max22Index.second + 1}")
    }

    if (maxListIndex == 2) { // 2Race
//        if (max1Index.first == max2Index.first) {
        var max22 = 0
        var max22Index = Pair(0, 0)

        field.forEachIndexed { index1, row ->
            row.forEachIndexed { index2, elem ->
                if (index1 != max2Index.first && elem > max22) {
                    max22 = elem
                    max22Index = Pair(index1, index2)
                }
            }
        }

        println("${max2Index.first + 1} ${max22Index.second + 1}")
    }

    if (maxListIndex == 1) { // 1Class
        var max22 = 0
        var max22Index = Pair(0, 0)

        field.forEachIndexed { index1, row ->
            row.forEachIndexed { index2, elem ->
                if (index2 != max1Index.second && elem > max22) {
                    max22 = elem
                    max22Index = Pair(index1, index2)
                }
            }
        }

        println("${max22Index.first + 1} ${max1Index.second + 1}")
    }

    if (maxListIndex == 3) { // 2Class
        var max22 = 0
        var max22Index = Pair(0, 0)

        field.forEachIndexed { index1, row ->
            row.forEachIndexed { index2, elem ->
                if (index2 != max2Index.second && elem > max22) {
                    max22 = elem
                    max22Index = Pair(index1, index2)
                }
            }
        }

        println("${max22Index.first + 1} ${max2Index.second + 1}")
    }


}