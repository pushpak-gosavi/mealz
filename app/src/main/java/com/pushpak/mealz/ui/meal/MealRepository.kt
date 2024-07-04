package com.pushpak.mealz.ui.meal

import com.pushpak.mealz.model.MealsCategoryResponse
import com.pushpak.mealz.network.MealWebService

class MealRepository (val webService: MealWebService = MealWebService()) {
    //fun getMeals(): MealsCategoryResponse = MealsCategoryResponse(arrayListOf())

    fun getMeals() : MealsCategoryResponse ?{
        return webService.getMeals().execute().body()
    }
}