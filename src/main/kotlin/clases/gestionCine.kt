package clases

import java.io.File
import kotlin.system.exitProcess

class gestionCine {

    private val cine = Cine()
    private val archivo = File("src/main/kotlin/clases/archivo.txt")

    init {
        cine.leerVentas(archivo)
    }

    fun mostrarCine(){
        println(cine.mostrarPantallaCine())
    }

    fun comprarAlCine(){

        var fila :Int
        do {
            println("introduce fila")
            fila = readln().toInt()-1
        }while (fila !in 0..cine.nFilas)

        var asiento :Int
        do {
            println("introduce asiento")
            asiento = readln().toInt()-1
        }while (asiento !in 0..cine.nAsientos)

        val butaca = Butaca(fila, asiento)

        if (cine.comprarEntrada(butaca)){
            println("-------------------------\n" +
                    "cine ${cine.nombreCine}\n" +
                    "fila: ${butaca.fila+1}\n" +
                    "butaca: ${butaca.asiento+1}\n" +
                    "-------------------------")
        }else println("butaca ya ocupada")
    }

    fun devolverAlCine(){

        var fila :Int
        do {
            println("introduce fila")
            fila = readln().toInt()-1
        }while (fila !in 0..cine.nFilas)

        var asiento :Int
        do {
            println("introduce asiento")
            asiento = readln().toInt()-1
        }while (asiento !in 0..cine.nAsientos)

        val butaca = Butaca(fila, asiento)

        if (cine.devolverEntrada(butaca)){
            println("operacion procesada")
        }else println("butaca no ocupada aun")
    }

    fun salir(){
        cine.guardarVentas(archivo)
        exitProcess(10)
    }
}