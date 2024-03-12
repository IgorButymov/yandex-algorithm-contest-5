package first

fun main(args: Array<String>) {
    var (p, v) = readLine()!!.split(' ').map { it.toInt() }
    var (q, m) = readLine()!!.split(' ').map { it.toInt() }



    if (p == q && v == m) {
        println(m * 2 + 1)
        return
    }

    if (v == 0 && m == 0) {
        if (p == q) println(1) else println(2)
        return
    }
    if (v == 0) {
        println(m * 2 + 1)
        return
    }
    if (m == 0) {
        println(v * 2 + 1)
        return
    }

    var leftP = p - v
    var rightP = p + v
    var leftQ = q - m
    var rightQ = q + m

    if (leftQ in leftP..rightP && rightQ in leftP..rightP) {
        println(rightP - leftP + 1)
        return
    }

    if (leftP in leftQ..rightQ && rightP in leftQ..rightQ) {
        println(rightQ - leftQ + 1)
        return
    }

    if (leftP < leftQ && leftP < rightQ && rightP < leftQ && rightP < rightQ) {
        println((rightP - leftP + 1) + (rightQ - leftQ + 1))
        return
    }

    if (leftP <= leftQ && leftP <= rightQ && rightP <= leftQ && rightP <= rightQ) {
        println(rightQ - leftP + 1)
        return
    }

    if (leftQ < leftP && leftQ < rightP && rightQ < leftP && rightQ < rightP) {
        println((rightP - leftP + 1) + (rightQ - leftQ + 1))
        return
    }

    if (leftQ <= leftP && leftQ <= rightP && rightQ <= leftP && rightQ <= rightP) {
        println(rightP - leftQ + 1)
        return
    }

    val list = listOf(leftP, rightP, leftQ, rightQ).sorted()
    println(list.last() - list.first() + 1)
}