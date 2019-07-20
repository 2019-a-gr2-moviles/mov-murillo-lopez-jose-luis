package com.example.localstore.adapter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.localstore.model.Bill
import com.example.localstore.model.Product
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class BillHttpAdapter {

    val url = "http://192.168.0.8:1337"

    fun getAll() : List<Bill>? {
        var currentUrl = "$url/allBills"

        var museumList : ArrayList<Bill>? = arrayListOf()
        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex =result.getException()
                        Log.i("testingxd", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("testingxd",data)
                        try {
                            val museumListAux = Klaxon().parseArray<Bill>(data)
                            museumListAux?.forEach {
                                museumList!!.add(it)
                            }
                            if (museumList != null) {
                                Bill.allBills = museumList
                            }
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando museos: $e")
                        }
                    }
                }
            }
        return museumList
    }

    fun newBill(body : Parameters){
        var currentUrl = "$url/Bills"
        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                if(result is Result.Failure) {
                    var ex = result.getException()
                    Log.i("httpError", "Error: $ex")
                }
            }
    }

    fun addProduct(body: Parameters){
        var currentUrl = "$url/BillProduct"
        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                if(result is Result.Failure) {
                    var ex = result.getException()
                    Log.i("httpError", "Error: $ex")
                }
            }
    }

}