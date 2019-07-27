package com.example.examen1b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_manage_ingredient_data.*

class ManageIngredientsDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_ingredient_data)
        val n = intent.getIntExtra("ingredient", 0)
        val foodID = intent.getIntExtra("foodID", 0)
        fillPage(n, foodID)
        btn_delete_ingredient.setOnClickListener {
            Snackbar.make(it, "${User.name} ${getString(R.string.deleteIngredientSnack)}", Snackbar.LENGTH_LONG).show()
            deleteIngredient(n, foodID)
        }
        btn_update_ingredient.setOnClickListener {
            Snackbar.make(it, "${User.name} ${getString(R.string.updateIngredientSnack)}", Snackbar.LENGTH_LONG).show()
            updateIngredient(n, foodID)
        }
    }

    fun deleteIngredient(ingredientID: Int, foodId :Int){
        Ingredient.ingredientsList.remove(Ingredient.searchByFood(Food.foodList[foodId])[ingredientID])
    }

    fun updateIngredient(ingredientID: Int, foodId: Int){
        val ingredientName = ingredient_name_input.text.toString()
        val quantity = ingredient_number_input.text.toString().toInt()
        val ingredientDescription = ingredient_desc_input.text.toString()
        val ingredientType = ingredient_type.text.toString()
        val cool = cool_check.isChecked
        val optional = optional_check.isChecked
        Ingredient.searchByFood(Food.foodList[foodId])[ingredientID].editIngredient(ingredientName, quantity, ingredientDescription, optional , ingredientType, cool)
    }

    fun fillPage(ingredientID : Int, foodID: Int){
        val ingredient = Ingredient.searchByFood(Food.foodList[foodID])[ingredientID]
        ingredient_name_input.setText(ingredient.ingredientName)
        ingredient_desc_input.setText(ingredient.prepDescription)
        ingredient_type.setText(ingredient.ingredientType)
        ingredient_number_input.setText(""+ingredient.quantity)
        optional_check.isChecked = ingredient.optional
        cool_check.isChecked = ingredient.coolNeeded
    }
}
