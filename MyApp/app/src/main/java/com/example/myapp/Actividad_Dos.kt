package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad__dos.*

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)
        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad",0)
        Log.i("intents","Nombre: $nombre")
        Log.i("intents", "Edad: $edad")
        btn_actividad_uno.setOnClickListener {
            IrAActividadUno()
        }
    }

    fun IrAActividadUno(){
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
