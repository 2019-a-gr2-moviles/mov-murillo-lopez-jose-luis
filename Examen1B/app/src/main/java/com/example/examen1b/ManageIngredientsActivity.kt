package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_manage_food.*
import kotlinx.android.synthetic.main.activity_manage_ingredients.*

class ManageIngredientsActivity : AppCompatActivity() {

    val namesList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        val n = intent.getIntExtra("foodID",0)
        initList(n)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_ingredients)
    }

    fun initList(foodID : Int){
        namesList.clear()
        val ingredients = Ingredient.searchByFood(Food.foodList[foodID])
        ingredients.forEach {
            namesList.add(it.ingredientName)
        }
        refreshList(foodID)
    }

    fun refreshList(foodID : Int){
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            namesList
        )
        lv_ingredients.adapter = adapter
        lv_ingredients.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goToIngredientDetail(position, foodID)
        }
    }

    fun goToIngredientDetail(position : Int, foodID: Int){
        val intent = Intent(
            this,
            ManageIngredientsDataActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("ingredient", position)
        intent.putExtra("foodID", foodID)
        startActivity(intent)
    }
}
