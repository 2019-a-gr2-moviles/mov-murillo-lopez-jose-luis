package com.example.newapp0523

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val jose : Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")

        val sherlock : Mascota? = this.intent.getParcelableExtra("mascota")

        Log.i("parcelable", "Nombre : ${jose?.nombre}")
        Log.i("parcelable", "Nombre : ${jose?.edad}")
        Log.i("parcelable", "Nombre : ${jose?.fechaNacimiento.toString()}")
        Log.i("parcelable", "Nombre : ${jose?.sueldo}")

        Log.i("parcelable", "Nombre : ${sherlock?.nombre}")

        btn_inicio.setOnClickListener {
            regresarMenu()
        }
    }

    fun regresarMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity :: class.java
        )
        startActivity(intentExplicito)
    }
}
