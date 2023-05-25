package clases

import java.io.File

class Cine {
    val nFilas = 10
    val nAsientos = 15
    val nombreCine="EFF"
    private var cine=Array(nFilas) {Array(nAsientos){0} }

    fun leerVentas(archivo:File){
        val lectorDeLineas = archivo.bufferedReader().readLines()
        for (linea in lectorDeLineas){
            val valores = linea.split(":")
            cine[valores[0].toInt()-1][valores[1].toInt()-1]=1
        }
    }

    fun guardarVentas(archivo: File){
        val escritorDeLineas = archivo.bufferedWriter()
        for (fila in cine.indices){
            for (asiento in cine[fila].indices){
                if(cine[fila][asiento]==1) {
                    escritorDeLineas.write("${fila + 1}:${asiento + 1}")
                    escritorDeLineas.newLine()
                }
            }
        }
        escritorDeLineas.close()
    }

    fun mostrarPantallaCine():String{
        var cadena = ""
        for (fila in cine){
            for (casilla in fila){
                cadena+= if (casilla==0) "__  " else "XX  "
            }
            cadena+="\n"
        }
        return cadena
    }

    fun comprarEntrada(butaca: Butaca):Boolean{
        val valores = butaca.toString().split(":")
        return if(cine[valores[0].toInt()][valores[1].toInt()]==0){
            cine[valores[0].toInt()][valores[1].toInt()]=1
            true
        }else false
    }

    fun devolverEntrada(butaca: Butaca):Boolean{
        val valores = butaca.toString().split(":")
        return if(cine[valores[0].toInt()][valores[1].toInt()]==1){
            cine[valores[0].toInt()][valores[1].toInt()]=0
            true
        }else false
    }

}