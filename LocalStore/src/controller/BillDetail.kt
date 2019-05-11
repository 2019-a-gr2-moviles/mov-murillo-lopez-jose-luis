package com.example.demo.controller

import com.example.demo.app.Product
import java.io.File

class BillDetail {

    var file = File("src/fileBase/billDetail.txt")


    fun insert(billID: Int, productID : Int) : Boolean{
        if(file.length().toInt()==0) {
            file.appendText("$billID,$productID")
        }else{
            file.appendText("${System.getProperty("line.separator")}$billID,$productID")
        }
        return true
    }

    fun select() : ArrayList<String> {
        var selectedValue : ArrayList<String> = ArrayList()
        file.forEachLine {
            val bill = it.split(",")
            selectedValue.add(it)
        }
        return selectedValue
    }

    fun select(storeId: Int) : ArrayList<Product> {
        var selectedValue : ArrayList<Product> = ArrayList()
        file.forEachLine {
            val bill = it.split(",")
            if(bill[0] == storeId.toString()){
                selectedValue.add(ProductController().select(bill[1]))
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