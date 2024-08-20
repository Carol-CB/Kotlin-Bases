package polimorfismoK
class Circulo : Forma() {
    override fun desenhar() {
        println("Desenhando um círculo!")
    }
}

fun main() {
    val forma : Forma = Circulo()
    forma.desenhar()
}


