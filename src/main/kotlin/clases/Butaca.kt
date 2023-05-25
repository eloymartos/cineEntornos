package clases

class Butaca(filaEntrada : Int, asientoEntrada : Int) {
    val fila = filaEntrada
    val asiento = asientoEntrada

    override fun toString(): String {
        return "$fila:$asiento"
    }
}