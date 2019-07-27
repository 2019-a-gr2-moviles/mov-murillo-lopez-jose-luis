package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_manage_food.*

class FoodActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val n = intent.getIntExtra("forSnack",0)
        Log.i("snack", "$n")
        when (n) {
            1 -> {
                Snackbar.make(food_layout, "${User.name} ${getString(R.string.deleteFoodSnack)}", Snackbar.LENGTH_LONG).show()
                Log.i("snack","insert")
            }
            0 -> Log.i("snack","no")
        }

        btn_manage_food.setOnClickListener {
            goToManagement()
        }

        btn_create_food.setOnClickListener {
            goToAdd()
        }

        btn_maps.setOnClickListener {
            goToMaps()
        }

    }

    fun goToManagement(){
        val intent = Intent(
            this,
            ManageFoodActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun goToAdd(){
        val intent = Intent(
            this,
            AddFoodActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun goToMaps(){
        val intent = Intent(
            this,
            MapsActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
