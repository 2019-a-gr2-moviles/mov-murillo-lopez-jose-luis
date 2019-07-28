package com.example.examen1b

import com.github.kittinunf.fuel.core.Parameters
import java.lang.reflect.Parameter

class Ingredient (var id : Int,
                  var ingredientName : String,
                  var quantity : Int,
                  var prepDescription : String,
                  var optional : Boolean,
                  var ingredientType : String,
                  var coolNeeded : Boolean,
                  var latitude : String,
                  var longitude : String) {

    companion object{
        var ingredientsList = arrayListOf<Pair<Ingredient, Int>>(
//            Ingredient("Yuca",1,"Haga hervir el caldo de atún y añada las yucas, cocine hasta que estén suaves.", false, "Tuberculo", false, Food.foodList[0]),
//            Ingredient("Tomate", 2, "Prepare en un refrito", true, "Vegetal", false, Food.foodList[0]),
//            Ingredient("Carne picada de ternera", 300, "Añadir a la cebolla sofrita", false, "Carne", true, Food.foodList[1]),
//            Ingredient("Huevo", 1, "Pintar la pestaña con huevo", true, "Huevo", false, Food.foodList[1]),
//            Ingredient("Carne", 2000, "Colocar la carne en una fuente y salarla.", false, "Carne", true, Food.foodList[2]),
//            Ingredient("Chorizo de cerdo", 4, "Ponerlos en agua", true, "Embutido", true, Food.foodList[2])
        )
        val adapter = IngredientHttpAdapter()

        fun add(body : Parameters, foodIndex : Int){
            adapter.new(body, foodIndex)
        }

        fun insertIntoList(){
            Food.foodList.forEachIndexed { index, food ->
                food.ingredients.forEach {
                    Ingredient.ingredientsList.add(it to index)
                }
            }
        }

        fun update(body : Parameters, id: Int){
            adapter.update(body, id)
        }

        fun delete(id : Int){
            adapter.delete(id)
        }

//        fun searchByFood(food : Food) : List<Ingredient>{
//            val ingredients = ingredientsList.filter { it.food == food }
//            return ingredients
//        }
    }

//    fun editIngredient(ingredientName : String, quantity : Int, prepDescription : String, optional : Boolean, ingredientType : String, coolNeeded : Boolean){
//        this.ingredientName = ingredientName
//        this.quantity = quantity
//        this.prepDescription = prepDescription
//        this.optional = optional
//        this.ingredientType = ingredientType
//        this.coolNeeded = coolNeeded
//    }



}