package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter {

    var url = MainActivity.url

    fun newUser(body : Parameters){
        var currentUrl = "$url/Usuario"
        currentUrl
            .httpPost(body)
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var user = Klaxon().parse<User>(data)
                        User.name = user!!.nombre
                    }
                }
            }
    }

}