package com.example.localstore.adapter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.localstore.model.Client
import com.example.localstore.model.Product
import com.example.localstore.model.User
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPatch
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class ClientHttpAdapter {

    val url = "http://192.168.0.8:1337"

    fun getClient(id : Int) : Client? {
        Log.i("testingxd","$id")
        var currentUrl = "$url/Client?user_person_FK=$id"
        Log.i("testingxd","$currentUrl")
        var client : Client? = null
        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex =result.getException()
                        Log.i("httpError", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        try {
                            var clientAux = Klaxon().parseArray<Client>(data)
                            Log.i("testingxd","$data")
                            if (clientAux != null) {
                                client = clientAux[0]
                                Client.currentClient = client
                            }
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando museos: $e")
                        }
                    }
                }
            }
        return client
    }

    fun register(bodyClient : Parameters, userName : String, password : String){
        var currentUrl = "$url/Client"
        currentUrl
            .httpPost(bodyClient)
            .responseString{ request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("httpError", "$ex")
                    }
                    is Result.Success -> {
                        var data = result.get()
                        var newClient = Klaxon().parse<Client>(data)
                        Client.currentClient = newClient
                        var userParameters = listOf(
                            "userName" to userName,
                            "password" to password,
                            "user_person_FK" to newClient?.id
                        )
                        User.adapter.register(userParameters)
                    }
                }

            }
    }

    fun updateClient(body : Parameters, id : Int) {
        var currentUrl = "$url/Client/$id"
        currentUrl
            .httpPatch(body)
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        var ex = result.getException()
                        Log.i("httpError", "$ex")
                    }
                    is Result.Success -> {
                        Log.i("testingxd", "Success")
                    }
                }

            }
    }

}