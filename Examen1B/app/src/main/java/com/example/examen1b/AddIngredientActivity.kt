package com.example.examen1b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_add_ingredient.*

class AddIngredientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingredient)
        val n = intent.getIntExtra("foodID", -1)
        btn_update_ingredient.setOnClickListener {
            addIngredient(n)
            Snackbar.make(it, "${User.name} ${getString(R.string.insertIngredientSnack)}", Snackbar.LENGTH_LONG).show()
        }
    }

    fun addIngredient(n : Int){
        val ingredientName = new_ingredient_name_input.text.toString()
        val quantity = new_ingredient_number_input.text.toString().toInt()
        val ingredientDescription = new_ingredient_desc_input.text.toString()
        val ingredientType = new_ingredient_type.text.toString()
        val cool = new_cool_check.isChecked
        val optional = new_optional_check.isChecked
        Ingredient.ingredientsList.add(Ingredient(ingredientName,quantity,ingredientDescription,optional,ingredientType,cool,Food.foodList[n]))
    }

}
