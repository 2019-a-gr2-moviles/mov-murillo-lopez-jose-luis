package com.example.app2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclio_vida.*
import kotlinx.android.synthetic.main.activity_main.*

class CiclioVidaActivity : AppCompatActivity() {

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclio_vida)
        Log.i("ciclo-vida", "onCreate")
        btn_counter.setOnClickListener {
            aumentarContador()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "onDestroy")
    }

    fun aumentarContador(){
        contador++
        tv_counter.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.i("ciclo-vida", "onSave")
        outState?.run {
            putInt("contadorGuardado", contador)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("ciclo-vida", "onRestore")
        var contadorRecuperado = savedInstanceState?.getInt("contadorGuardado")
        if(contadorRecuperado != null){
            this.contador = contadorRecuperado
            this.tv_counter.text = "${this.contador}"
        }
    }


}
