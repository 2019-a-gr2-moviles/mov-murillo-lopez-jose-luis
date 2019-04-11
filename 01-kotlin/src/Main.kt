fun main(args: Array<String>){
    //Variables
    // Mutables:
    var nombre = "José"
    nombre = "Luis"
    //Inmutables:
    val nombreI = "José"
    //nombreI = "Luis"

    //Tipos de datos
    val apellido: String = "Murillo"
    val edad: Int = 21
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    //Condicionales
    if(apellido == "Murillo" && nombre == "Luis"){
        println("Verdadero")
    }else{
        println("Falso")
    }

    val tieneNombreYApellido = if(apellido!=null && nombre!=null) "ok" else "no"

    println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)


}

fun estaJalado (nota:Double){
    when (nota){
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Genial :D felicitaciones")
        }
        0.0 -> {
            println("Dios mío que vago!")
        }
        else -> {
            println("Tu nota es: $nota")
            //println("Tu nota es ${nota.valor})"
        }
    }
}






