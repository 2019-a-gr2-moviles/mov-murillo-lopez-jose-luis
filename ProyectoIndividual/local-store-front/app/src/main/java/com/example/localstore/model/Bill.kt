package com.example.localstore.model

import com.example.localstore.adapter.BillAdapter
import com.example.localstore.adapter.BillHttpAdapter
import java.util.*
import kotlin.collections.ArrayList

class Bill(
    var id : Int,
    var date : String,
    var totalCost : Double,
    var products : ArrayList<Product>
)
{

    var productsList : ArrayList<Product> = arrayListOf()

    companion object{
        var allBills = arrayListOf<Bill>()
        var adapter = BillHttpAdapter()
    }

}