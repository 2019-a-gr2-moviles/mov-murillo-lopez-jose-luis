package com.example.localstore.model

import com.example.localstore.adapter.ProductHttpAdapter

class ShopCart {

    companion object{
        var shoppingCart = arrayListOf<Product>()
        var cartCount = mutableMapOf<Int, Int>()
        var adapter = ProductHttpAdapter()

        fun existsOnCart(id : Int) : Int {
            var count : Int = 0
            shoppingCart.forEach {
                if(it.id == id){
                    count ++
                }
            }
            return count
        }

        fun insertIntoShopCart(product : Product){
            var count = existsOnCart(product.id)
            if(count == 0){
                shoppingCart.add(product)
                cartCount.put(product.id, 1)
            }else{
                var num: Int = cartCount[product.id]!!
                cartCount[product.id] = num + 1
            }
        }

        fun calculatePrice() : Double{
            var totalPrice = 0.0
            shoppingCart.forEach {
                totalPrice += (it.price * cartCount[it.id]!!)
            }
            return totalPrice
        }

        fun deleteFromCart(product : Product) : Int{
            var toReturn = 0
            if(cartCount[product.id] == 1){
                shoppingCart.remove(product)
                cartCount.remove(product.id)
            }else{
                var num: Int = cartCount[product.id]!!
                cartCount[product.id] = num - 1
                toReturn =1
            }
            return toReturn
        }

    }

}