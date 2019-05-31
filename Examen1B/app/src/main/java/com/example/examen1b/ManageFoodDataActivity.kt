package com.example.examen1b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_manage_food_data.*

class ManageFoodDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_food_data)
        val n = intent.getIntExtra("foodID",0)
        Log.i("final", "$n")
        val food = Food.foodList[n]
        food_name_input.setText(food.foodName)
        food_desc_input.setText(food.foodDescription)
        food_country_input.setText(food.nacionality)
        food_number_input.setText(""+food.numberPeople)
        hot_spicy_check.isChecked = food.hotSpicy
    }
}
