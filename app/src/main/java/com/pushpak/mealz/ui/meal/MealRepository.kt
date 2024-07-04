package com.pushpak.mealz.ui.meal

import com.pushpak.mealz.model.MealsCategoryResponse
import com.pushpak.mealz.network.MealWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(val webService: MealWebService = MealWebService()) {
    //fun getMeals(): MealsCategoryResponse = MealsCategoryResponse(arrayListOf())

    fun getMeals(successCallback: (response: MealsCategoryResponse?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealsCategoryResponse> {
            override fun onResponse(
                call: Call<MealsCategoryResponse>,
                response: Response<MealsCategoryResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoryResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}