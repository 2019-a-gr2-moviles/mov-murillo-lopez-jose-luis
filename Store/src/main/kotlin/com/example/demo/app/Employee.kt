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


}