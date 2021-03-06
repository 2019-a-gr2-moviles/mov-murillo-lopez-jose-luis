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

    holaMundo("José")
    holaMundoAvanzado(627)

    val total = sumarDosNumeros(3,5)
    println(total)

    val arregloCumple = intArrayOf(1,2,3,4)

    val arregloTodo = arrayOf(1,"asd",10.2,true)

    arregloCumple[0] = 5
    arregloCumple.set(0, 8)

    //val fecha = Date()
    //fecha.time = 1123212

    val notas = arrayListOf(1,2,3,4,5,6)

    notas.forEach { nota ->
        println(nota)
    }

    //Itera el arreglo
    notas.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
        //return Unit
    }

    //Itera y modifica el arreglo
    val notasDos = notas.map{nota->
        nota + 1
    }

    notasDos.forEach{
        println(it)
    }

//    val notasTre = notas.map{nota ->
//        if (nota%2 == 1){
//            nota+1
//        }else{
//            nota +2
//        }
//    }

    //Muta o cambia el arreglo
    val notasTre = notas.map{nota ->
        val modulo = nota % 2
        val esPar = 0
        when(modulo){
            esPar->{
                nota + 2
            }
            else ->{
                nota +1
            }
        }
    }

    notasTre.forEach {
        println("Notas3: $it")
    }

    //Filtra el arreglo
    val respuestaFilter = notas.filter {
        it in 3..4
        //Same as it > 2 && it < 5
    }.map{
        it*2
    }

    respuestaFilter.forEach {
        println(it)
    }

    val novias = arrayListOf(1,2,2,3,4,5)
    //ALGUNO es igual a 7?
    val respuestaNovia = novias.any{
        it == 7
    }

    println(respuestaNovia)

    val tazos = arrayListOf(1,2,3,4,5,6,7)
    //TODOS son mayores a 1?
    val respuestaTazos = tazos.all{
        it > 1
    }

    println(respuestaTazos)

    val totalTazos =tazos.reduce { valorAcumulado, tazo->
        valorAcumulado + tazo
    }

    println(totalTazos)

    val numerito = Numero("1");

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


fun holaMundo(mensaje:String):Unit {
    println(mensaje)
}


fun holaMundoAvanzado(mensaje:Any):Unit {
    println(mensaje)
}


fun sumarDosNumeros(numUno:Int, numDos:Int):Int{
    return numUno+numDos
}

/*
------------------------------------------------------------------
-------------------------Clases-----------------------------------
------------------------------------------------------------------
 */

class Usuario(val cedula:String){
    public var nombre:String = ""
    public var apellido:String = ""


    constructor(cedulaM:String, apellido:String):this(cedulaM){
        this.apellido = apellido
    }

}

class UsuarioKT(public val nombre:String,
                public val apellido:String,
                private var id:Int
                //,protected var id: Int
                ){

    public fun hola():String{
        return this.apellido
    }

    init{

    }

    companion object {
        val gravedad = 10.5;
        fun correr(){
            println("estoy corriendo en $gravedad")
        }
    }

}

fun a() {
    val jose = UsuarioKT("jose", "murillo", 7198)
    println(jose.nombre)

    val jose2 = Usuario("a")
    jose2.nombre = " "
    jose2.apellido = " "
}

class Numero(var numero:Int){
    constructor(numeroString:String) : this(numeroString.toInt()) {
        println("Constructor")
    }

    init{
        println("init")
    }
}

fun aa(){
    UsuarioKT.gravedad;
    UsuarioKT.correr();
    Numero(5);
}

abstract class Numeros (var numeroUno : Int, var numeroDos : Int){

}

class Suma(numeroUnos:Int, numeroDoss:Int) : Numeros(numeroUnos,numeroDos){

}

fun cc(){
    val a = Suma(1, 2)
    //Clase abstracta
    //val b = Numeros(1,2)

}




fun presley(requerido:Int,
            opcional:Int=1, //Parametro opcional
            nulo:UsuarioKT?       //A veces va a ser nulo
            ){

    if(nulo!=null){
        nulo.nombre
    }

    val nombresito = nulo?.nombre.toString(); //Elvis operator

    nulo!!.nombre //Sé que existirá! solo hazlo!
}

fun cd(){
    presley(requerido = 1, nulo = 0)
    presley (1,1,0)
    presley(1,1,null)
    presley(null,1,2)

}
















