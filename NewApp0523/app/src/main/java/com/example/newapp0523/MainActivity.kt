package com.example.newapp0523

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }

        btn_adapter.setOnClickListener {
            irAListView()
        }

    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this, Parcelable::class.java
        )

        val jose = Usuario("Jose", 21, Date(), 10.0)
        intentExplicito.putExtra("usuario", jose)

        val sherlock = Mascota("Sherlock", jose)
        intentExplicito.putExtra("mascota", sherlock)

        startActivity(intentExplicito)

    }

    fun irAListView(){
        val intent = Intent(
            this,
            ListViewActivity::class.java
        )
        startActivity(intent)
    }

}
