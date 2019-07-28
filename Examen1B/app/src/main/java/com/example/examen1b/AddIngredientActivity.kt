package com.example.examen1b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
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
        val ingredient = listOf(
            "ingredientName" to new_ingredient_name_input.text.toString(),
            "quantity" to new_ingredient_number_input.text.toString().toInt(),
            "prepDescription" to new_ingredient_desc_input.text.toString(),
            "ingredientType" to new_ingredient_type.text.toString(),
            "coolNeeded" to new_cool_check.isChecked,
            "optional" to new_optional_check.isChecked,
            "latitude" to new_i_lat.text.toString(),
            "longitude" to new_i_lng.text.toString(),
            "food_FK" to Food.foodList[n].id
        )
        Ingredient.add(ingredient, n)
    }

}
