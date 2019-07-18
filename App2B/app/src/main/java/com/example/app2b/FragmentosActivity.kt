package com.example.app2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primer.setOnClickListener {
            abrirPrimerFragmento()
        }
    }

    fun abrirPrimerFragmento(){
        //1. Manager
        val fragmentManager = supportFragmentManager
        //2. Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        //3. Definir la instancia del fragmento
        val primerFragmento = PrimerFragment()
        //4. Reemplazamos el fragmento
        transaccion.replace(R.id.cl_fragmentos, primerFragmento)
        //5. Terminar la transaccion
        transaccion.commit()
    }

    fun abrirSegundoFragmento(){
        //1. Manager
        val fragmentManager = supportFragmentManager
        //2. Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        //3. Definir la instancia del fragmento
        val primerFragmento = SegundoFragment()
        //4. Reemplazamos el fragmento
        transaccion.replace(R.id.cl_fragmentos, primerFragmento)
        //5. Terminar la transaccion
        transaccion.commit()
    }

    fun abrirTercerFragmento(){
        //1. Manager
        val fragmentManager = supportFragmentManager
        //2. Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        //3. Definir la instancia del fragmento
        val tercerFragmento = TercerFragment()
        //4. Reemplazamos el fragmento
        transaccion.replace(R.id.cl_fragmentos, tercerFragmento)
        //5. Terminar la transaccion
        transaccion.commit()
    }




}
