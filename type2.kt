import kotlin.math.pow

fun f(fx: List<List<Int>>, x:Double): Double {
    var value = 0.0
    fx.forEach{ value += it[0] * x.pow(it[1]) }
    return value
}
fun main() {
    print("f(x) = ")
    val exp = readLine()!!.replace("-", "+-")
            .split("+")
            .filter { it.contains("x") }
            .map { if (it.endsWith("x")) "$it^1" else it }
            .map { it.split("x^") }
    val terms = exp.map { listOf(it[0].toInt(), it[1].toInt()) }

    print("x = ")
    val x = readLine()!!.toDouble()
    var h = 0.0000001
    while (h > 0) {
        val fxh = f(terms, x + h)
        val fx = f(terms, x)
        println("lim h->$h (f(x+h)-f(x))/h = ${(fxh - fx)/h}")
        h -= 0.000000001
    }
}
