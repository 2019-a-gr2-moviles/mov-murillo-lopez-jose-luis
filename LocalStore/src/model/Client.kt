package com.example.demo.app

class Client (id:String,
              firstName : String,
              lastName : String,
              gender : String,
              age : Int,
              phoneNumber : String,
              address : String) : Person(id, firstName, lastName, gender, age, phoneNumber, address) {

    fun propertiesNames(): Array<String> {
        val columnNames = arrayOf("Id","Nombres","Apellidos","Genero","Edad","Número de telefono","Dirección")
        return columnNames
    }
}