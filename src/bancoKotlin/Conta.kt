package bancoKotlin

class Conta(
    val titular: String,
    val identificador: String,
    private var senha: String,
    private var saldo: Float = 0.0f
) {

    fun depositar(valor: Float) {
        if (valor > 0) {
            saldo += valor
            println("Depósito de R$$valor realizado!")
        } else {
            println("O valor do depósito deve ser maior que zero.")
        }
    }

    fun sacar(valor: Float): Boolean {
        return if (valor > 0 && valor <= saldo) {
            saldo -= valor
            println("Saque de R$$valor realizado!")
            true
        } else {
            println("Saldo insuficiente.")
            false
        }
    }

    fun verificarSaldo(): String {
        return "Saldo atual: R$$saldo"
    }

    fun autenticar(senha: String): Boolean {
        return this.senha == senha
    }
}