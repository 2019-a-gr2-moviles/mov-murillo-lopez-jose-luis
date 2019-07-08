package com.example.app2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import java.lang.Exception
import java.util.*

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)
        val json = """
        [
        {
        "usuarioDeEmpresa": [
          {
            "createdAt": 1561062002418,
            "updatedAt": 1561150921809,
            "id": 1,
            "nombre": "Jose",
            "fkEmpresa": 1
          }
        ],
        "createdAt": 1561150738096,
        "updatedAt": 1561150738096,
        "id": 1,
        "nombre": "EPN"
      }
        ]
        """.trimIndent()

        try{
            val empresaInstancia = Klaxon().parseArray<Empresa>(json)
            empresaInstancia?.forEach {
                Log.i("http", "Nombre: ${it.nombre}")
                Log.i("http", "ID: ${it.id}")
                if (empresaInstancia != null) {
                    Log.i("http", "Fecha: ${Date(it.createdAt)}")
                }
                it.usuarioDeEmpresa.forEach{
                    Log.i("http","Nombre: ${it.nombre}")
                }
            }
        }catch (e : Exception){
            Log.i("http", "error instanciando la empresa")
        }

        val url = "http://192.168.0.12:1337/Empresa/2"

        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val empresaParseada = Klaxon().parse<Empresa>(data)
                        if(empresaParseada != null){
                            Log.i("http"," iiiiiiiiiiiiiiiiiiii ")
                            Log.i("http","${empresaParseada.nombre} ")
                            Log.i("http","${empresaParseada.id} ")
                        }
                    }
                }
            }

        val urlCrearEmpresa = "http://192.168.0.12:1337/Empresa"

        val parametrosCrearEmpresa = listOf(
            "nombre" to "Manticore Labs2"
        )

        urlCrearEmpresa
            .httpPost(parametrosCrearEmpresa)
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: $data")
                    }
                }
            }
        //De buffer a imagen


    }
}
