package com.example.demo.app

class Employee(id:String,
               firstName : String,
               lastName : String,
               gender : String,
               age : Int,
               phoneNumber : String,
               address : String,
               val charge: String,
               val reportsTo : Employee?,
               val bankAccount : String) : Person(id, firstName, lastName, gender, age, phoneNumber, address) {

    fun propertiesNames(): Array<String> {
        val columnNames = arrayOf("Id","Nombres","Apellidos","Genero","Edad","Número de telefono","Dirección","Cargo","Reporta a","Cuenta bancaria")
        return columnNames
    }

}