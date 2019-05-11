package com.example.demo.app


class Product (var id : Int,
               var type : String,
               var name : String,
               var description : String,
               var price : Float) {

    fun propertiesNames(): Array<String> {
        val columnNames = arrayOf("Id","Tipo","Nombre","Descripción","Precio")
        return columnNames

    }

}
