package com.example.examen1b

class Ingredient (var ingredientName : String,
                  var quantity : Int,
                  var prepDescription : String,
                  var optional : Boolean,
                  var ingredientType : String,
                  var coolNeeded : Boolean,
                  var food : Food) {

    companion object{
        val ingredientsList = arrayListOf<Ingredient>()
    }

}