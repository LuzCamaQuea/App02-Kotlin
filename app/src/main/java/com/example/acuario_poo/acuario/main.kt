package com.example.acuario_poo.acuario
import kotlin.math.PI

fun main() {
    var acuario: Acuario? = null

    while (true) {
        imprimirOpciones()
        val opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            0 -> {
                println("Saliendo del programa...")
                break
            }
            1 -> acuario = crearAcuario()
            2 -> acuario = seleccionarFormaAcuario(acuario)
            3 -> verDetallesAcuario(acuario)
            4 -> calcularPeces(acuario)
            5 -> acuario = calcularDimensionesParaPeces()
            6 -> modificarDimensiones(acuario)
            7 -> modificarCantidadAgua(acuario)
            8 -> imprimirOpciones()
            else -> println("Opcion invalida, intente nuevamente.")
        }
    }
}

fun imprimirOpciones() {
    println("""
        === Menu de Opciones ===
        0 -> Salir
        1 -> Crear acuario
        2 -> Seleccionar forma del acuario (Rectangular o Cilindrico)
        3 -> Ver detalles del acuario
        4 -> Calcular cuantos peces puedo poner
        5 -> Calcular dimensiones de un acuario para x peces
        6 -> Modificar dimensiones del acuario
        7 -> Modificar cantidad de agua en el acuario
        8 -> Mostrar nuevamente las opciones
    """.trimIndent())
    print("Ingrese una opcion: ")
}

fun crearAcuario(): Acuario {
    println("Acuario creado con valores por defecto.")
    return Acuario()
}

fun seleccionarFormaAcuario(acuario: Acuario?): Acuario? {
    if (acuario == null) {
        println("Primero debe crear un acuario.")
        return null
    }

    println("Elija la forma del acuario:")
    println("1 -> Rectangular")
    println("2 -> Cilindrico")
    val forma = readLine()?.toIntOrNull()

    return when (forma) {
        1 -> Acuario()
        2 -> {
            print("Ingrese la altura del tanque cilindrico: ")
            val alto = readLine()?.toIntOrNull() ?: 40
            print("Ingrese el diametro del tanque cilindrico: ")
            val diametro = readLine()?.toIntOrNull() ?: 20
            TanqueTorre(alto, diametro)
        }
        else -> {
            println("Opcion invalida.")
            acuario
        }
    }
}

fun verDetallesAcuario(acuario: Acuario?) {
    acuario?.imprimirTamano() ?: println("Primero debe crear un acuario.")
}

fun calcularPeces(acuario: Acuario?) {
    if (acuario == null) {
        println("Primero debe crear un acuario.")
        return
    }
    val peces = (acuario.agua * 1000 / (2000 * 1.1)).toInt()
    println("Puede poner aproximadamente $peces peces en el acuario.")
}

fun calcularDimensionesParaPeces(): Acuario {
    print("Ingrese la cantidad de peces: ")
    val peces = readLine()?.toIntOrNull()
    if (peces == null || peces <= 0) {
        println("Cantidad invalida.")
        return Acuario()
    }
    println("Acuario ajustado para $peces peces.")
    val acuario = Acuario(peces)
    acuario.imprimirTamano()
    return acuario
}

fun modificarDimensiones(acuario: Acuario?) {
    if (acuario == null) {
        println("Primero debe crear un acuario.")
        return
    }

    print("Ingrese nuevo alto: ")
    val nuevoAlto = readLine()?.toIntOrNull()
    print("Ingrese nuevo ancho: ")
    val nuevoAncho = readLine()?.toIntOrNull()
    print("Ingrese nuevo largo: ")
    val nuevoLargo = readLine()?.toIntOrNull()

    if (nuevoAlto != null && nuevoAncho != null && nuevoLargo != null) {
        acuario.alto = nuevoAlto
        acuario.ancho = nuevoAncho
        acuario.largo = nuevoLargo
        println("Dimensiones actualizadas.")
    } else {
        println("Valores invalidos.")
    }
}

fun modificarCantidadAgua(acuario: Acuario?) {
    if (acuario == null) {
        println("Primero debe crear un acuario.")
        return
    }

    print("Ingrese el porcentaje de llenado de agua (0-100): ")
    val porcentaje = readLine()?.toDoubleOrNull()
    if (porcentaje != null && porcentaje in 0.0..100.0) {
        acuario.agua = acuario.volumen * (porcentaje / 100)
        println("Cantidad de agua actualizada.")
    } else {
        println("Porcentaje invalido.")
    }
}