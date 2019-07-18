package com.example.localstore.adapter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.localstore.model.Client
import com.example.localstore.model.Product
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class ClientHttpAdapter {

    val url = "http://192.168.0.8:1337"

    fun getClient(id : Int) : Client? {
        var currentUrl = "$url/Client?user_person_FK=$id"

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
                            client = Klaxon().parse<Client>(data)
                            if (client != null) {
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

    fun register(body : Parameters){
        var currentUrl = "$url/Client"
        currentUrl
            .httpPost(body)
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
                    }
                }

            }
    }

}