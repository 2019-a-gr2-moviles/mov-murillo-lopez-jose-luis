package com.example.demo.app

class Bill ( val id : Int,
             val storeId : Int,
             val employeeId : String,
             val clientId : String,
             products : ArrayList<Product>) {

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


}