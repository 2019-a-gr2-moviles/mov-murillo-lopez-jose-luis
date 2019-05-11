package com.example.demo.controller

import com.example.demo.app.Bill
import java.io.File

class BillController {

    var file = File("src/fileBase/bill.txt")

    fun insert(id : Int, storeId : Int, employeeId : String, clientId : String, detailID : Int, price : Float) : Boolean{
        return if (exists(id)){
            false
        }else{
            if(file.length().toInt()==0){
                file.appendText("$id,$storeId,$employeeId,$clientId,$detailID,$price")
            }else{
                file.appendText("${System.getProperty("line.separator")}$id,$storeId,$employeeId,$clientId,$detailID,$price")
            }
            true
        }
    }

    fun select(id: Int) : Bill{
        var selectedValue : Bill? = null
        file.forEachLine {
            val bill = it.split(",")
            if(bill[0] == id.toString()){
                selectedValue = Bill(bill[0].toInt(), bill[1].toInt(), bill[2], bill[3], BillDetail().select( bill[4].toInt()))
            }
        }
        return selectedValue!!
    }

    fun select() : ArrayList<Bill> {
        var selectedValue : ArrayList<Bill> = ArrayList()
        file.forEachLine {
            val bill = it.split(",")
            selectedValue.add(Bill(bill[0].toInt(), bill[1].toInt(), bill[2], bill[3], BillDetail().select(bill[4].toInt())))
        }
        return selectedValue
    }

    fun delete(id: Int) : Boolean {
        if(!exists(id)){
            return false
        } else{
            var deleteHandler : ArrayList<String> = ArrayList()
            file.forEachLine {
                val bill = it.split(",")
                if(bill[0] != id.toString()){
                    deleteHandler.add(it + "\n")
                }
            }
            file.writeText("")
            deleteHandler.forEach {
                file.appendText(it)
            }
            return true
        }
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