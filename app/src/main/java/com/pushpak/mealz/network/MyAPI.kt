package com.pushpak.mealz.network

import com.pushpak.mealz.model.MealsCategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealWebService {
    private lateinit var myAPI: MyAPI
    init {
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(myAPI::class.java)

    }

    fun getMeals() : Call<MealsCategoryResponse>{
        return myAPI.mealzcategory()
    }
}
public interface MyAPI {
    @GET("categories.php")
    fun mealzcategory() : Call<MealsCategoryResponse>

}