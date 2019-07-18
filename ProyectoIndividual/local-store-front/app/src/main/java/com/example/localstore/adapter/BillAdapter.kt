package com.example.localstore.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.localstore.R
import com.example.localstore.model.Bill
import com.example.localstore.views.BillsFragment

class BillAdapter (
    private val billsList : ArrayList<Bill>,
    private val context : BillsFragment,
    private val recyclerView : RecyclerView
) : RecyclerView.Adapter<BillAdapter.MyViewHolder>()
{

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val product = billsList[p1]
        p0.billId.text = "${p0.billId.text} ${product.id}"
        p0.billPrice.text = "$ ${product.totalCost}"
        p0.billDate.text = product.date.toString()
    }

    override fun getItemCount(): Int {
        return billsList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(
            R.layout.product_layout,
            p0,
            false
        )
        return MyViewHolder(itemView, p1)
    }

    inner class MyViewHolder (view : View, p1 : Int) : RecyclerView.ViewHolder(view) {

        var billId : TextView
        var billDate : TextView
        var billPrice : TextView

        init{

            billId = view.findViewById(R.id.tv_bill_id)
            billDate = view.findViewById(R.id.tv_date)
            billPrice = view.findViewById(R.id.tv_price)

            var layout = view.findViewById<ConstraintLayout>(R.id.cl_bills)

            layout.setOnClickListener {

            }

        }

    }
}