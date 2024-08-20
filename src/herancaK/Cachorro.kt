package herancaK
class Cachorro(nome: String) : Animal(nome) {
    fun latir() {
        println("$nome está latindo.")
    }
}

fun main() {
    val cachorro = Cachorro("Toinha")
    cachorro.comer()
    cachorro.latir()
}

