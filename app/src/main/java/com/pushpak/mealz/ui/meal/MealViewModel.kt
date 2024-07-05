package com.pushpak.mealz.ui.meal

import androidx.lifecycle.ViewModel
import com.pushpak.mealz.model.MealsCategory
import com.pushpak.mealz.model.MealsCategoryResponse

class MealViewModel(private val mealRepository: MealRepository = MealRepository()) : ViewModel() {
   suspend fun getMeals() : List<MealsCategory> {
       return mealRepository.getMeals().categories
    }
}