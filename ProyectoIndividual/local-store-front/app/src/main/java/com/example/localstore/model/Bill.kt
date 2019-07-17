package com.example.localstore.model

import java.util.*
import kotlin.collections.ArrayList

class Bill(
    var id : Int,
    var date : Date,
    var totalCost : Double,
    var products : ArrayList<Product>
)
{


    companion object{
        var allBills = arrayListOf<Bill>()
    }

}