package com.example.app2b

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)
        btn_intent_respuesta.setOnClickListener {
            enviarIntentConRespuesta()
        }

        btn_respuesta_propia.setOnClickListener {
            enviarIntentConRespuestaPropia()
        }
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        this.startActivityForResult(intentConRespuesta, 304)
    }

    fun enviarIntentConRespuestaPropia(){
        val intent = Intent(
            this,
            ResultadoPropioActivity :: class.java
        )
        this.startActivityForResult(intent, 305)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            RESULT_OK -> {
                Log.i("intent-respuesta", "Lo logramos ${Activity.RESULT_OK}")
                when(requestCode){
                    304 -> {
                        Log.i("intent-respuesta", "Contacto llegó :3")
                        val uri = data?.data
                        val cursor = contentResolver.query(uri,
                            null,
                            null,
                            null,
                            null)

                        cursor.moveToFirst()

                        val indiceTelefono = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        val telefono = cursor.getString(indiceTelefono)

                        cursor?.close()

                        Log.i("intent-respuesta", "El telefono es $telefono")
                    }
                    305 -> {
                        val nombre = data?.getStringExtra("nombre_usuario")
                        val edad = data?.getIntExtra("edad_usuario",0)
                        Log.i("intent-respuesta", "Nombre: $nombre y Edad: $edad")
                    }
                }
            }
            RESULT_CANCELED -> {
                Log.i("intent-respuesta", "No escogió")
            }
        }
    }

}
