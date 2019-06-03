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

    override fun onResume() {
        super.onResume()
        val n = intent.getIntExtra("forSnack",0)
        when (n) {
            2 -> Snackbar.make(manage_layout, "${User.name} ${getString(R.string.deleteFoodSnack)}", Snackbar.LENGTH_LONG).show()
            3 -> Snackbar.make(manage_layout, "${User.name} ${getString(R.string.updateFoodSnack)}", Snackbar.LENGTH_LONG).show()
        }
        initList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_food)
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
        namesList.clear()
        Food.foodList.forEach {
            namesList.add(it.foodName)
        }
        refreshList()
    }

    fun refreshList(){
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
}
