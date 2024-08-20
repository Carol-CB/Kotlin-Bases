package construtoresK
class Livro(val titulo: String, val autor: String, val anoPublicacao: Int)

fun main() {
    val livro1 = Livro("O Retrato de Dorian Gray", "Oscar Wilde", 1890)
    println("Título: ${livro1.titulo}, Autor: ${livro1.autor}, Ano: ${livro1.anoPublicacao}")
}


