package com.example.localstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        var mDividerItemDecoration = DividerItemDecoration(
            rv_products.getContext(),
            LinearLayout.VERTICAL
        )
        rv_products.addItemDecoration(mDividerItemDecoration)

        val lista = arrayListOf<Producto>()
        lista.add(Producto("Cereal Minis fresa", 5.25, R.drawable.cereal2))
        lista.add(Producto("Cereal Minis chocolate", 7.25, R.drawable.cereal3))
        lista.add(Producto("Barra energética", 2.50, R.drawable.cereal4))
        lista.add(Producto("Headset", 50.00, R.drawable.headset))
        lista.add(Producto("Pepsi", 1.25, R.drawable.pepsi))
        lista.add(Producto("Te", 1.75, R.drawable.te))
        iniciarRecyclerVirew(lista, this, rv_products)
    }

    fun iniciarRecyclerVirew (lista : ArrayList<Producto>, actividad: MainActivity, recyclerView: RecyclerView){
        val adaptadorProducto = AdaptadorProducto(
            lista,
            actividad,
            recyclerView
        )
        recyclerView.adapter = adaptadorProducto
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(actividad)

        adaptadorProducto.notifyDataSetChanged()
    }

    fun irAProductDeatil(){

    }
}
