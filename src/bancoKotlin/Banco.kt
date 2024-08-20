package bancoKotlin

import kotlin.random.Random
class Banco {
    private val contas = mutableListOf<Conta>()

    private fun gerarIdentificadorUnico(): String {
        var identificador: String
        do {
            identificador = gerarIdentificador()
        } while (contas.any { it.identificador == identificador })
        return identificador
    }

    private fun gerarIdentificador(): String {
        val letras = ('A'..'Z').toList()
        val numeros = (0..9).toList()

        val letra1 = letras[Random.nextInt(letras.size)]
        val letra2 = letras[Random.nextInt(letras.size)]
        val numero1 = numeros[Random.nextInt(numeros.size)]
        val numero2 = numeros[Random.nextInt(numeros.size)]

        return "$letra1$letra2$numero1$numero2"
    }

    private fun criarConta(titular: String, senha: String): Conta {
        val identificador = gerarIdentificadorUnico()
        val novaConta = Conta(titular, identificador, senha)
        contas.add(novaConta)
        println("Conta criada com sucesso no nome de $titular! Identificador: $identificador")
        return novaConta
    }

    private fun acessarConta(identificador: String, senha: String): Conta? {
        val conta = contas.find { it.identificador == identificador }
        return if (conta != null && conta.autenticar(senha)) {
            conta
        } else {
            println("O identificador ou a senha estão incorretos.")
            null
        }
    }

    fun operacoesBancarias() {
        println("Bem-vindo (a)!")
        while (true) {
            println("\nEscolha uma opção:")
            println("(1) Criar conta")
            println("(2) Acessar conta")
            println("(3) Sair")

            when (readLine()) {
                "1" -> {
                    println("Informe o titular da conta:")
                    val titular = readLine() ?: ""
                    println("Informe a senha:")
                    val senha = readLine() ?: ""
                    criarConta(titular, senha)
                }
                "2" -> {
                    println("Informe o identificador da conta:")
                    val identificador = readLine() ?: ""
                    println("Informe a senha:")
                    val senha = readLine() ?: ""
                    val conta = acessarConta(identificador, senha)

                    if (conta != null) {
                        while (true) {
                            println("\nEscolha uma operação:")
                            println("(1) Depositar")
                            println("(2) Sacar")
                            println("(3) Verificar saldo")
                            println("(4) Sair")

                            when (readLine()) {
                                "1" -> {
                                    println("Informe o valor:")
                                    val valor = readLine()?.toFloatOrNull() ?: 0.0f
                                    conta.depositar(valor)
                                }
                                "2" -> {
                                    println("Informe o valor:")
                                    val valor = readLine()?.toFloatOrNull() ?: 0.0f
                                    conta.sacar(valor)
                                }
                                "3" -> {
                                    println(conta.verificarSaldo())
                                }
                                "4" -> break
                                else -> println("Opção inválida.")
                            }
                        }
                    }
                }
                "3" -> {
                    println("Obrigado! Até mais!")
                    break
                }
                else -> println("Opção inválida.")
            }
        }
    }
}
fun main() {
    val banco = Banco()
    banco.operacoesBancarias()
}