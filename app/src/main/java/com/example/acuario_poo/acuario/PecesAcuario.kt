package com.example.acuario_poo.acuario

abstract class Pez {
    abstract val color:String
}
class Tiburon : Pez(), AccionPez {
    override val color: String
        get() = "gris"

    override fun comer() {
        println("Cazar y comer peces")
    }
}
class PezPayaso : Pez(), AccionPez {
    override val color: String
        get() = "dorado"

    override fun comer() {
        println("Comer algas")
    }
}

interface AccionPez{
    fun comer()
}