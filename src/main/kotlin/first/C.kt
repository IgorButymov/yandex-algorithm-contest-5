package first

fun main(args: Array<String>) {
    // space = +1
    // tab = +4
    // backspace = -1
    val n = readln().toInt()

    val spaces = mutableListOf<Int>()

    for (i in 1..n) {
        spaces.add(readln().toInt())
    }

    var res: Long = 0

    //13024153355
    //2147483647

    spaces.forEachIndexed { _, space ->
        if (space == 1) {
            res += 1
        } else if (space == 0) {
            res += 0
        } else if (space == 2) {
            res += 2
        } else if ((space / 4.0) - (space / 4.0).toInt() == 0.0) {
            res += space / 4
        } else {
            val temp = space / 4
            val left = temp * 4
            val right = (temp + 1) * 4
            if (space - left <= right - space + 1) {
                res += space - left + temp
            } else {
                res += right - space + temp + 1
            }
        }
    }

    println(res)
}