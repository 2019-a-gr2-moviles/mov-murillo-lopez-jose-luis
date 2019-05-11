package com.example.demo.app

import java.util.*

class Bill ( val id : Int,
             val storeId : Int,
             val employeeId : String,
             val clientId : String,
             public var products : ArrayList<Product>) {

    var partialPrice : Float = 0.0f
    var iva : Float = 0.0f
    var totalPrice : Float = 0.0f

    init {
        products.forEach{
            totalPrice += it.price
        }
        iva = totalPrice * 0.12f
        partialPrice = totalPrice - iva
    }

    fun propertiesNames(): Array<String> {
        val columnNames = arrayOf("Id de Factura","Id de Tienda","Id de Empleado","Id de cliente","Productos","Valor a pagar")
        return columnNames
    }


}