package com.example.racipe_app.Database_Repository

import com.example.racipe_app.Model.Model_Food
import com.example.racipe_app.R

class Food_repository {

    fun getMockFoodList(): List<Model_Food> {
        return listOf(

            Model_Food("Chicken Biryani", R.drawable.spicie_biryaniii),
            Model_Food("Karahi Chicken", R.drawable.biryanii),
            Model_Food("Seekh Kebab", R.drawable.piza2),
            Model_Food("Aloo Gosht", R.drawable.piza),
            Model_Food("Haleem", R.drawable.piza2),
            Model_Food("Nihari", R.drawable.burger22),
            Model_Food("Chapli Kebab", R.drawable.piza),

            Model_Food("Beef Biryani", R.drawable.biryani),
            Model_Food("Chicken Korma", R.drawable.chawal),
            Model_Food("Palak Paneer", R.drawable.piza2),
            Model_Food("Daal Chawal", R.drawable.spicie_biryaniii),
            Model_Food("Paya", R.drawable.piza2),
            Model_Food("Chana Chaat", R.drawable.chawal),
            Model_Food("Murgh Cholay", R.drawable.piza)
        )
    }

    fun fetchIngredients(recipeName: String?): List<String> {
        return when (recipeName) {
            "Chicken Biryani" -> listOf("Chicken", "Rice", "Yogurt", "Spices", "Onions", "Tomatoes")
            "Karahi Chicken" -> listOf(
                "Chicken",
                "Tomatoes",
                "Green Chilies",
                "Ginger",
                "Garlic",
                "Spices"
            )

            "Seekh Kebab" -> listOf("Minced Meat", "Onions", "Green Chilies", "Coriander", "Spices")
            "Aloo Gosht" -> listOf("Beef", "Potatoes", "Onions", "Tomatoes", "Spices")
            "Haleem" -> listOf("Meat", "Lentils", "Wheat", "Ginger", "Garlic", "Spices")
            "Nihari" -> listOf("Beef Shank", "Nihari Masala", "Ginger", "Garlic", "Flour", "Ghee")
            "Chapli Kebab" -> listOf(
                "Minced Meat",
                "Tomatoes",
                "Onions",
                "Green Chilies",
                "Spices",
                "Corn Flour"
            )

            "Beef Biryani" -> listOf("Beef", "Rice", "Yogurt", "Spices", "Onions", "Tomatoes")
            "Chicken Korma" -> listOf("Chicken", "Yogurt", "Onions", "Spices", "Ginger", "Garlic")
            "Palak Paneer" -> listOf(
                "Spinach",
                "Paneer",
                "Tomatoes",
                "Onions",
                "Spices",
                "Ginger",
                "Garlic"
            )

            "Daal Chawal" -> listOf("Lentils", "Rice", "Onions", "Tomatoes", "Spices", "Garlic")
            "Paya" -> listOf("Trotters", "Ginger", "Garlic", "Onions", "Spices", "Wheat Flour")
            "Chana Chaat" -> listOf(
                "Chickpeas",
                "Potatoes",
                "Onions",
                "Tomatoes",
                "Chaat Masala",
                "Tamarind"
            )

            "Murgh Cholay" -> listOf(
                "Chicken",
                "Chickpeas",
                "Onions",
                "Tomatoes",
                "Spices",
                "Ginger",
                "Garlic"
            )

            else -> emptyList()
        }

    }



}