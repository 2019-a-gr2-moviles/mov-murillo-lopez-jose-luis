package com.example.demo.controller

import com.example.demo.app.Product
import java.io.File

class BillDetail {

    var file = File("D:\\Documents\\Kotlin Projects\\Store\\fileBase\\billDetail.txt")


    fun insert(billID: Int, productID : Int) : Boolean{
        return if (exists(billID)){
            false
        }else{
            file.appendText("$billID,$productID${System.getProperty("line.separator")}")
            true
        }
    }

    fun select(storeId: Int) : ArrayList<Product> {
        var selectedValue : ArrayList<Product> = ArrayList()
        file.forEachLine {
            val bill = it.split(",")
            if(bill[0] == storeId.toString()){
                selectedValue.add(Product(bill[0].toInt(), bill[1], bill[2], bill[3], bill[4].toFloat()))
            }
        }
        return selectedValue
    }


    fun exists(id : Int) : Boolean {
        var itExists = false
        file.forEachLine {
            val bill = it.split(",")
            if(bill[0] == id.toString()){
                itExists = true
            }
        }
        return itExists
    }

}