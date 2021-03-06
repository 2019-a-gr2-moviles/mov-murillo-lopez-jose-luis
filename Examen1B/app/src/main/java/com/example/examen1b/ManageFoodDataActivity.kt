package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_manage_food_data.*

class ManageFoodDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_food_data)
        val n = intent.getIntExtra("foodID",0)
        fillPage(n)
        btn_delete_food.setOnClickListener {
            deleteFood(n)
            Snackbar.make(it, "${User.name} ${getString(R.string.deleteFoodSnack)}", Snackbar.LENGTH_LONG).show()
        }
        btn_update_food.setOnClickListener {
            updateFood(n)
            Snackbar.make(it, "${User.name} ${getString(R.string.updateFoodSnack)}", Snackbar.LENGTH_LONG).show()
        }
        btn_update_ingredient.setOnClickListener {
            goToNewIngredient(n)
        }
        btn_ingredients_management.setOnClickListener {
            goToIngredientManagement(n)
        }
    }

    fun deleteFood(n : Int){
        Food.foodList.removeAt(n)
        //goToManage(2)
    }

    fun updateFood(n : Int){
        Food.foodList[n].editFood(
            food_name_input.text.toString(),
            food_desc_input.text.toString(),
            food_country_input.text.toString(),
            food_number_input.text.toString().toInt(),
            hot_spicy_check.isChecked
        )
        //goToManage(3)
    }

    fun goToManage(from : Int){
        val intent = Intent(
            this,
            ManageFoodActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("forSnack", from)
        startActivity(intent)
    }

    fun goToNewIngredient(from: Int){
        val intent = Intent(
            this,
            AddIngredientActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("foodID", from)
        startActivity(intent)
    }

    fun goToIngredientManagement(from: Int){
        val intent = Intent(
            this,
            ManageIngredientsActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("foodID", from)
        startActivity(intent)
    }

    fun fillPage(n : Int){
        val food = Food.foodList[n]
        food_name_input.setText(food.foodName)
        food_desc_input.setText(food.foodDescription)
        food_country_input.setText(food.nacionality)
        food_number_input.setText(""+food.numberPeople)
        hot_spicy_check.isChecked = food.hotSpicy
    }
}

