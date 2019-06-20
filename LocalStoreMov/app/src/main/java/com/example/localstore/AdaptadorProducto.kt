package com.example.localstore

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorProducto (private val listaProductos : ArrayList<Producto>,
                         private val contexto : MainActivity,
                         private val recyclerView: RecyclerView) : RecyclerView.Adapter<AdaptadorProducto.MyViewHolder>() {
    inner class MyViewHolder (view : View) :RecyclerView.ViewHolder(view){

        var nombreProducto : TextView
        var precioProducto : TextView
        var imagenProducto : ImageView

        init {

            nombreProducto = view.findViewById(R.id.tv_name)
            precioProducto = view.findViewById(R.id.tv_price)
            imagenProducto = view.findViewById(R.id.iv_product)

            val layout = view.findViewById<LinearLayout>(R.id.ll_vertical)
            layout.setOnClickListener {
                Log.i("testing","It works!")

            }
            imagenProducto.setOnClickListener {
                val indice = getListIndex(nombreProducto.text.toString())
                when(imagenProducto.tag){
                    R.drawable.cereal2 -> listaProductos[indice].foto = R.drawable.cereal3
                    R.drawable.cereal3 -> listaProductos[indice].foto = R.drawable.cereal2
                    R.drawable.cereal4 -> listaProductos[indice].foto = R.drawable.cereal2
                    R.drawable.headset -> listaProductos[indice].foto = R.drawable.pepsi
                    R.drawable.pepsi -> listaProductos[indice].foto = R.drawable.headset
                    R.drawable.te -> listaProductos[indice].foto = R.drawable.headset
                }
                contexto.iniciarRecyclerVirew(listaProductos,contexto,recyclerView)
            }
        }

        fun getListIndex(name : String) : Int{
            var toReturn = -1
            listaProductos.forEachIndexed { index, producto ->
                if(producto.nombre == name){
                    toReturn = index
                }
            }
            return toReturn
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(
            R.layout.producto_layout,
            p0,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val producto = listaProductos[p1]
        p0.nombreProducto.text = producto.nombre
        p0.precioProducto.text = "U${'$'}S ${producto.precio}"
        p0.imagenProducto.setImageResource(producto.foto)
        p0.imagenProducto.tag = producto.foto
    }
}