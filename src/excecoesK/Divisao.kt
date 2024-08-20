package excecoesK
fun dividir(a: Int, b: Int): Int {
    return try {
        a / b
    } catch (e: ArithmeticException) {
        println("Erro: divisão por zero não permitida.")
        0
    }
}
fun main() {
    val resultado = dividir(10, 0)
    println("Resultado: $resultado")
}

