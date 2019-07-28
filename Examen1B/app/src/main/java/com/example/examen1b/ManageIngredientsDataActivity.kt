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
      //  Ingredient.ingredientsList.remove(Ingredient.searchByFood(Food.foodList[foodId])[ingredientID])
        Ingredient.delete(Food.foodList[foodId].ingredients[ingredientID].id)
    }

    fun updateIngredient(ingredientID: Int, foodId: Int){
        val body = listOf(
            "ingredientName" to ingredient_name_input.text.toString(),
            "quantity" to ingredient_number_input.text.toString().toInt(),
            "prepDescription" to ingredient_desc_input.text.toString(),
            "ingredientType" to ingredient_type.text.toString(),
            "cool" to cool_check.isChecked,
            "optional" to optional_check.isChecked,
            "latitude" to input_latitude.text.toString(),
            "longitude" to input_longitude.text.toString()
        )
        Ingredient.update(body, Food.foodList[foodId].ingredients[ingredientID].id)
       // Ingredient.searchByFood(Food.foodList[foodId])[ingredientID].editIngredient(ingredientName, quantity, ingredientDescription, optional , ingredientType, cool)
    }

    fun fillPage(ingredientID : Int, foodID: Int){
        val ingredient = Food.foodList[foodID].ingredients[ingredientID]
        ingredient_name_input.setText(ingredient.ingredientName)
        ingredient_desc_input.setText(ingredient.prepDescription)
        ingredient_type.setText(ingredient.ingredientType)
        ingredient_number_input.setText(""+ingredient.quantity)
        optional_check.isChecked = ingredient.optional
        cool_check.isChecked = ingredient.coolNeeded
        input_latitude.setText(ingredient.latitude)
        input_longitude.setText(ingredient.longitude)
    }
}
