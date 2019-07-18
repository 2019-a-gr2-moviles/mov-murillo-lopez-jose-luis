package com.example.localstore.adapter

import android.os.AsyncTask
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.localstore.model.User
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter : AsyncTask<String, Integer, User?>() {

    val url = "http://192.168.0.8:1337/login"

    override fun doInBackground(vararg params: String?): User? {
        var user = params[0]
        var pass = params[1]
        val body = listOf(
            "userName" to user,
            "password" to pass
        )
        var usuario : User? = null
        val (request, response, result) = url
            .httpPost(body)
            .responseString()

        when(result){
            is Result.Failure ->{
                val ex = result.getException()
                Log.i("testingxd", "Error $ex")
            }
            is Result.Success -> {
                val data = result.get()
                var usuarioAux = Klaxon().parse<User>(data)
                if(usuarioAux != null){
                    usuario = usuarioAux
                    User.currentUser = usuario
                }
            }
        }
        return usuario
    }

    fun register(body : Parameters){
        var currentUrl = "$url/User"
        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result){
                    is Result.Failure -> {
                        var ex = result.getException()
                        Log.i("httpError", "Error: $ex")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var newUser = Klaxon().parse<User>(data)
                        User.currentUser = newUser
                    }
                }

            }
    }



}