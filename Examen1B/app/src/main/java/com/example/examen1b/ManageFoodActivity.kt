package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_manage_food.*

class ManageFoodActivity : AppCompatActivity() {

    private val namesList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_food)
        initList()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            namesList
        )

        lv_food.adapter = adapter

        lv_food.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goToFoodDetail(position)
        }
    }

    fun goToFoodDetail(position : Int){
        val intent = Intent(
            this,
            ManageFoodDataActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("foodID", position)
        startActivity(intent)
    }

    fun initList(){
        Food.foodList.add(Food("Encebollado","Sopa de cebolla", "Ecuador",1, false))
        Food.foodList.add(Food("Pie floater","Pastel de carne flotante", "Australia",1, false))
        Food.foodList.add(Food("Asado","Asados de carne", "Argentina",5, false))
        Food.foodList.add(Food("Cangrejo al chili","Comida de marisco", "Singapur",2, true))
        Food.foodList.add(Food("Jamón de Parma","Jamón crudo", "Italia",1, false))
        Food.foodList.add(Food("Goi cuon","Rollitos", "Vietnam",2, true))

        Food.foodList.forEach {
            namesList.add(it.foodName)
        }
    }
}
