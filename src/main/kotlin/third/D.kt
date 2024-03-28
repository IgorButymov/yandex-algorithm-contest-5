package third

fun main(args: Array<String>) {
    val firstRow = readln().split(" ").map { it.toInt() }
    val n = firstRow[0]
    val k = firstRow[1] + 1

    val nums = readln().trim().split(" ").map { it.toInt() }

    if (n == 1 || n == 0) {
        println("NO")
        return
    }

    // todo: брать n + 1 для sliding window

    var set = mutableSetOf<Int>()

    if (k >= n) {
        for (i in 0..n-1) {
            set.add(nums[i])
        }
        if (set.size == n) {
            println("NO")
            return
        } else {
            println("YES")
            return
        }
    }

    for (i in 0..k-1) {
        set.add(nums[i])
    }

    if (n == 2 && set.size != n) {
        println("YES")
        return
    }

    if (set.size != k) {
        println("YES")
        return
    }

    for (i in k..n - 1) {
        set.remove(nums[i - k])
        set.add(nums[i])
        if (set.size != k) {
            println("YES")
            return
        }
    }

    println("NO")
}