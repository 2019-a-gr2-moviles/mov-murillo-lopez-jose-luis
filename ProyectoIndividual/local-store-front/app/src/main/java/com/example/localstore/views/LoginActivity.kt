package com.example.localstore.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.localstore.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login_action.setOnClickListener {
            goToHomeActivity()
        }

    }

    fun goToHomeActivity(){
        var intent = Intent(
            this,
            HomeActivity :: class.java
        )
        startActivity(intent)
    }
}
