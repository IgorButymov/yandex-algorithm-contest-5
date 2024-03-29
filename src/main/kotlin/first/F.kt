package first

fun main(args: Array<String>) {
    val n = readln().toInt()
    val nums = readln().split(" ").map { if (it.toInt().and(1) == 0) 0 else 1 }
    var res = ""
    var current = nums[0]

    for (i in 1..n-1) {
        if ((nums[i] == 0 && current == 1) || nums[i] == 1 && current == 0) {
            current = 1
            res += "+"
        } else if (nums[i] == 1 && current == 1) {
            //current == 1
            res += "x"
        } else {
            current == 0
            res += "+"
        }
    }

    println(res)
}