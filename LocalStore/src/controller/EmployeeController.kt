package com.example.demo.controller

import com.example.demo.app.Client
import com.example.demo.app.Employee
import java.io.File

class EmployeeController {

    var file = File("src/fileBase/employee.txt")

    fun insert(id : String, firstName : String, lastName : String, gender : String, age : Int, phoneNumber : String, address : String, charge : String, reportsTo : String, bankAccount : String) : Boolean{
        return if (exists(id)){
            false
        }else{
            if(file.length().toInt()==0) {
                file.appendText("$id,$firstName,$lastName,$gender,$age,$phoneNumber,$address,$charge,$reportsTo,$bankAccount")
            }else {
                file.appendText("${System.getProperty("line.separator")}$id,$firstName,$lastName,$gender,$age,$phoneNumber,$address,$charge,$reportsTo,$bankAccount")
            }
            true
        }
    }

    fun select(id: String) : Employee{
        var selectedValue : Employee? = null
        file.forEachLine {
            val client = it.split(",")
            if(client[0] == id) {
                if (client[8] == "") {
                    selectedValue = Employee(client[0], client[1], client[2], client[3], client[4].toInt(), client[5], client[6], client[7], null, client[9])
                }else{
                    selectedValue = Employee(client[0], client[1], client[2], client[3], client[4].toInt(), client[5], client[6], client[7], select(client[8]), client[9])
                }
            }
        }
        return selectedValue!!
    }

    fun select() : ArrayList<Employee> {
        var selectedValue : ArrayList<Employee> = ArrayList()
        file.forEachLine {
            val client = it.split(",")
            selectedValue.add(Employee(client[0], client[1], client[2], client[3], client[4].toInt(), client[5], client[6], client[7], null, client[9]))
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
                        "phoneNumber" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), newValue, client[6], client[7], client[8], client[9])
                        }
                        "addres" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), client[5], newValue, client[7], client[8], client[9])
                        }
                        "charge" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), client[5], client[6], newValue, client[8], client[9])
                        }
                        "reportsTo" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), client[5], client[6], client[7], newValue, client[9])
                        }
                        "bankAccount" -> {
                            delete(id)
                            insert(id, client[1], client[2], client[3], client[4].toInt(), client[5], client[6], client[7], client[8], newValue)
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