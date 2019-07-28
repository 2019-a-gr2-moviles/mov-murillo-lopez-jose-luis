package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.result.Result

class FoodHttpAdapter {

    val url = MainActivity.url

    fun getAll() {
        var currentUrl = "$url/Food"

        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex =result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        try {
                            val museumListAux = Klaxon().parseArray<Food>(data)
                            Food.foodList = museumListAux!!.toCollection(ArrayList())
                            Ingredient.insertIntoList()
                        }catch (e : Exception){
                            Log.i("http", "Error buscando comida: $e")
                        }
                    }
                }
            }
    }

    fun new(body : Parameters){
        var currentUrl = "$url/Food"

        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var newFood = Klaxon().parse<Food>(data)
                        Food.foodList.add(newFood!!)
                    }
                }
            }
    }

    fun edit(body: Parameters, id: Int){
        var currentUrl = "$url/Food/$id"

        currentUrl
            .httpPut(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var newFood = Klaxon().parse<Food>(data)
                        if(newFood != null){
                            Food.initializeList()
                        }
                    }
                }
            }
    }

    fun delete(id : Int){
        var currentUrl = "$url/Food/$id"

        currentUrl
            .httpDelete()
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var newFood = Klaxon().parse<Food>(data)
                        if(newFood != null){
                            Food.initializeList()
                        }
                    }
                }
            }
    }

}