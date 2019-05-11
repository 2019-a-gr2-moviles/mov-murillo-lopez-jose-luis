package com.example.demo.controller

import com.example.demo.app.Bill
import com.example.demo.app.Client
import java.io.File

class ClientController {


    var file = File("D:\\Documents\\Kotlin Projects\\Store\\fileBase\\client.txt")

    fun insert(id : String, firstName : String, lastName : String, gender : String, age : Int, phoneNumber : String, address : String) : Boolean{
        return if (exists(id)){
            false
        }else{
            file.appendText("$id,$firstName,$lastName,$gender,$age,$phoneNumber,$address${System.getProperty("line.separator")}")
            true
        }
    }

    fun select(id: String) : Client{
        var selectedValue : Client? = null
        file.forEachLine {
            val client = it.split(",")
            if(client[0] == id){
                selectedValue = Client(client[0], client[1], client[2], client[3], client[4].toInt(), client[5], client[6])
            }
        }
        return selectedValue!!
    }

    fun select() : ArrayList<Client> {
        var selectedValue : ArrayList<Client> = ArrayList()
        file.forEachLine {
            val client = it.split(",")
            selectedValue.add(Client(client[0], client[1], client[2], client[3], client[4].toInt(), client[5], client[6]))
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
                file.appendText(it)
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
                        "phoneNumber" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), newValue, client[6])
                        }
                        "addres" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), client[5], newValue)
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