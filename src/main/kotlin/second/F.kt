package second

fun main(args: Array<String>) {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val lastRow = readln().split(" ").map { it.toInt() }

    var a = lastRow[0]
    val b = lastRow[1]
    val k = lastRow[2]

//    val elementsA = a / k
//    val elementsB = b / k

    val elementsA = customDivide(a, k)
    val elementsB = customDivide(b, k)

    val roundsA = customDivide(elementsA, n)
    val roundsB = customDivide(elementsB, n)

    val formattedElementsA = elementsA - roundsA * n
    val formattedElementsB = elementsB - roundsB * n

//    nums[formattedElementsA]
//    nums[nums.size - formattedElementsA]

    var max = 0

    if (roundsA == roundsB) {
        for (i in formattedElementsA..formattedElementsB) {
            if (i == n) {
                if (nums[0] > max) max = nums[0]
            } else {
                if (nums[i] > max) max = nums[i]
            }
        }

        for (i in n - formattedElementsB..n - formattedElementsA) {
            if (i == n) {
                if (nums[0] > max) max = nums[0]
            } else {
                if (nums[i] > max) max = nums[i]
            }
        }

        println(max)
        return
    } else if (roundsB > roundsA) {
        println(nums.max())
        return
    }
}

fun customDivide(a: Int, b: Int): Int {
    if (a <= b) return 0
    if (a % b == 0) return a / b - 1
    return a / b
}