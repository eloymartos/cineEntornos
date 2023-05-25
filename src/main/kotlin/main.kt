
import clases.gestionCine

fun main(){
    val gestor = gestionCine()
    while (true){
        println("1. Mostrar butacas\n2. Comprar entrada\n3. Devolver una entrada\n4. Salir")
        val respuesta = readln().toInt()
        when (respuesta){
            1->{
                gestor.mostrarCine()
            }
            2->{
                gestor.comprarAlCine()
            }
            3->{
                gestor.devolverAlCine()
            }
            4->{
                gestor.salir()
            }
            else-> print("valor invalido, intente de nuevo")
        }
    }
}

