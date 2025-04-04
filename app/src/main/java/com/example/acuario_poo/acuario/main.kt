package com.example.acuario_poo.acuario
import kotlin.math.PI
fun construirAcuario(){
    val miAcuario = Acuario(ancho = 25, largo = 25, alto = 40)
    miAcuario.imprimirTamano()
    val miTorre = TanqueTorre(diametro = 25, alto = 40)
    miTorre.imprimirTamano()

}
fun main() {
    construirAcuario()
}