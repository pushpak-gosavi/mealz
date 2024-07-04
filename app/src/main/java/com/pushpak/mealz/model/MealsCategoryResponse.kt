package com.pushpak.mealz.model

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(
     val categories: List<MealsCategory>
)

data class MealsCategory(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String,
    @SerializedName("strCategoryDescription")  val description: String
)
