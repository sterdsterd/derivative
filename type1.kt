fun main() {
    val sup = listOf("⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹")
    val exp = readLine()!!.replace("-", "+-")
                            .split("+")
                            .filter { it.contains("x") }
                            .map { if (it.endsWith("x")) "$it^1" else it }
    val terms = exp.map { it.split("x^") }
    val derivative = terms.map { listOf(it[0].toInt() * it[1].toInt(), it[1].toInt() - 1) }
    var expDerivative = ""
    derivative.forEachIndexed { i, it ->
        if (i != 0 && it[0] >= 0) expDerivative += "+"
        expDerivative += "${it[0]}"
        if (it[1] == 1) expDerivative += "x"
        else if (it[1] > 0) expDerivative += "x${sup[it[1]]}"
    }
    
    print("f'(x)=$expDerivative")
    //TODO : 계수 = 1일때 예외 처리
}
