package com.pushpak.mealz.ui.meal

import com.pushpak.mealz.model.MealsCategoryResponse
import com.pushpak.mealz.network.MealWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(val webService: MealWebService = MealWebService()) {
    //fun getMeals(): MealsCategoryResponse = MealsCategoryResponse(arrayListOf())

    suspend fun getMeals() : MealsCategoryResponse {
        return webService.getMeals()
    }
}