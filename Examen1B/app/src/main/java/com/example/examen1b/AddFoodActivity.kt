package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        btn_new_food.setOnClickListener {
            Snackbar.make(it, "${User.name} ${getString(R.string.insertFoodSnack)}", Snackbar.LENGTH_LONG).show()
            insertFood()
        }
    }

    fun insertFood(){
        val foodName = new_food_name_input.text.toString()
        val foodDescription = new_food_desc_input.text.toString()
        val foodCountry = new_food_country_input.text.toString()
        val foodNumber = new_food_number_input.text.toString().toInt()
        val foodHotSpicy = new_optional_check.isChecked
        Food.foodList.add(Food(foodName,foodDescription,foodCountry,foodNumber,foodHotSpicy))
        //goToMainFood()
    }

    fun goToMainFood(){
        val intent = Intent(
            this,
            FoodActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("forSnack", 1)
        startActivity(intent)
    }


}
