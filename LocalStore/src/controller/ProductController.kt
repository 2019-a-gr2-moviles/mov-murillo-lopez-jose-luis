package com.example.demo.controller

import com.example.demo.app.Client
import com.example.demo.app.Product
import java.io.File

class ProductController {

    var file = File("src/fileBase/product.txt")

    fun insert(id : Int, type : String, name : String, description : String, price : Float) : Boolean{
        return if (exists(id.toString())){
            false
        }else{
            if(file.length().toInt()==0) {
                file.appendText("$id,$type,$name,$description,$price")
            }else {
                file.appendText("${System.getProperty("line.separator")}$id,$type,$name,$description,$price")
            }
            true
        }
    }

    fun select(id: String) : Product{
        var selectedValue : Product? = null
        file.forEachLine {
            val client = it.split(",")
            if(client[0] == id && it != ""){
                selectedValue = Product(client[0].toInt(), client[1], client[2], client[3], client[4].toFloat())
            }
        }
        return selectedValue!!
    }

    fun select() : ArrayList<Product> {
        var selectedValue : ArrayList<Product> = ArrayList()
        file.forEachLine {
            val client = it.split(",")
            if(it != "")
                selectedValue.add(Product(client[0].toInt(), client[1], client[2], client[3], client[4].toFloat()))
        }
        return selectedValue
    }

    fun delete(id: String) : Boolean {
        if(!exists(id)){
            return false
        } else{
            var deleteHandler : ArrayList<String> = ArrayList()
            file.forEachLine {
                val bill = it.split(",")
                if(bill[0] != id){
                    deleteHandler.add(it)
                }
            }
            file.writeText("")
            deleteHandler.forEach {
                file.appendText(it + "\n")
            }
            return true
        }
    }

    fun update(id : String, header : String, newValue : String) : Boolean{
        if(exists(id)){
            file.forEachLine {
                val client = it.split(",")
                if(client[0] == id){
                    when(header){
                        "description" -> {
                            delete(id)
                            insert(id.toInt(), client[1], client[2], newValue, client[4].toFloat())
                        }
                        "price" -> {
                            delete(id)
                            insert(id.toInt(), client[1], client[2], client[3], newValue.toFloat())
                        }
                    }
                }
            }
            return true
        }else{
            return false
        }
    }

    fun exists(id : String) : Boolean {
        var itExists = false
        file.forEachLine {
            val bill = it.split(",")
            if(bill[0] == id){
                itExists = true
            }
        }
        return itExists
    }

}