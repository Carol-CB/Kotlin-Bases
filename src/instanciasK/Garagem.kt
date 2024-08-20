package instanciasK
import atributosK.Carro
class Garagem {
    fun main() {
        val carro1 = Carro()
        carro1.marca = "Honda"
        carro1.ano = 2022

        println("Marca: ${carro1.marca}, Ano: ${carro1.ano}")
    }
}

