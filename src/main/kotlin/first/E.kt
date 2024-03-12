package first

import java.math.BigInteger

fun main(args: Array<String>) {
    val row = readln().split(" ")
    val n = BigInteger(row[0]) // изначальная прибыль
    val k = BigInteger(row[1]) // кол-во учередетилей
    val d = (row[2].toLong()) // кол-во дней

    var res = n.toString()
    var prevRes = res

    for (i in 1..d) {
        for (j in 0..9) {
            if (BigInteger(res + j) % k == BigInteger.ZERO) {
                res += j
                break
            }
        }
        if (res == prevRes) {
            println(-1)
            return
        }
        prevRes = res
        if (res.last() == '0') {
            res += "0".repeat((d-i).toInt())
            break
        }
    }

    println(res)
}