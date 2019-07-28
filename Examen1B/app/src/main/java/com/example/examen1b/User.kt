package com.example.examen1b

class User (var nombre : String){

companion object{
    var name : String = ""
    var adapter = UserHttpAdapter()

    fun newUser(name : String){
        var body = listOf(
            "nombre" to name
        )
        adapter.newUser(body)
    }
}

}