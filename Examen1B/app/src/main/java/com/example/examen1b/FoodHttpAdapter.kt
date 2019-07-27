package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class FoodHttpAdapter {

    val url = MainActivity.url

    fun getAll() {
        var currentUrl = "$url/>Food"

        var museumList : ArrayList<Food>? = arrayListOf()
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
                            val museumListAux = Klaxon().parseArray<Food>(data)
                            museumListAux?.forEach {
                                museumList!!.add(it)
                            }
                            if (museumList != null) {
                                Food.list = museumList
                            }
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando museos: $e")
                        }
                    }
                }
            }
    }


}