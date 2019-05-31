package com.example.examen1b

class Food (var foodName : String,
            var foodDescription : String,
            var nacionality : String,
            var numberPeople : Int,
            var hotSpicy : Boolean) {

    companion object{
        val foodList = arrayListOf<Food>()
    }
}