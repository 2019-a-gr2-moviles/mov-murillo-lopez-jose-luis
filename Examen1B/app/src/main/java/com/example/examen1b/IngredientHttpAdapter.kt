package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

class IngredientHttpAdapter {

    var url = MainActivity.url

    fun new(body : Parameters, foodIndex : Int){
        var currentUrl = "$url/Ingredient"

        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error : $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        val newIngredient = Klaxon().parse<Ingredient>(data)
                        if (newIngredient != null) {
                            Food.foodList[foodIndex].ingredients.add(newIngredient)
                            Ingredient.ingredientsList.add(newIngredient to foodIndex)
                        }
                    }
                }
            }
    }

    fun update(body: Parameters, id: Int){
        var currentUrl = "$url/Ingredient/$id"

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
                        var newFood = Klaxon().parse<Ingredient>(data)
                        if(newFood != null){
                            Food.initializeList()
                        }
                    }
                }
            }
    }

    fun delete(id : Int){
        var currentUrl = "$url/Ingredient/$id"

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
                        var newFood = Klaxon().parse<Ingredient>(data)
                        if(newFood != null){
                            Food.initializeList()
                        }
                    }
                }
            }
    }


}