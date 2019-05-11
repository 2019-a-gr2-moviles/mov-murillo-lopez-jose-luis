package com.example.demo.app

import com.example.demo.view.MainView
import tornadofx.*

class Branch (val id : Int,
              val name : String,
              val addres : String,
              val city : String){

    var bills : ArrayList<Bill> = ArrayList()
    var employees : ArrayList<Employee> = ArrayList()
    var products : ArrayList<Product> = ArrayList()

}