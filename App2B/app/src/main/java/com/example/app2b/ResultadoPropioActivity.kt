package com.example.app2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_devolver_respuesta.setOnClickListener {
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val nombre = "José"
        val edad = 21

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("nombre_usuario", nombre)
        intentRespuesta.putExtra("edad_usuario", edad)

        this.setResult(
            RESULT_OK,
            intentRespuesta
        )

        this.finish()

    }
}
