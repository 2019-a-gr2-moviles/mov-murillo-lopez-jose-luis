package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var url = "http://192.168.0.8:1337"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Food.initializeList()
        btn_enter.setOnClickListener {
            logIn()
        }
    }

    fun logIn(){
        User.newUser(user_input.text.toString())
        val intent = Intent(
            this,
            FoodActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
