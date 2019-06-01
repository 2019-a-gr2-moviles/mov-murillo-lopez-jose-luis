package com.example.examen1b

class Food (var foodName : String,
            var foodDescription : String,
            var nacionality : String,
            var numberPeople : Int,
            var hotSpicy : Boolean) {

    companion object{
        val foodList = arrayListOf<Food>(
            Food("Encebollado", "Sopa de cebolla", "Ecuador", 1, false),
            Food("Pie floater", "Pastel de carne flotante", "Australia", 1, false),
            Food("Asado", "Asados de carne", "Argentina", 5, false),
            Food("Cangrejo al chili", "Comida de marisco", "Singapur", 2, true),
            Food("Jamón de Parma", "Jamón crudo", "Italia", 1, false),
            Food("Goi cuon", "Rollitos", "Vietnam", 2, true)
        )
    }

    fun editFood(foodName : String, foodDescription : String, nacionality : String, numberPeople : Int, hotSpicy : Boolean){
        this.foodName = foodName
        this.foodDescription = foodDescription
        this.nacionality = nacionality
        this.numberPeople = numberPeople
        this.hotSpicy = hotSpicy
    }
}