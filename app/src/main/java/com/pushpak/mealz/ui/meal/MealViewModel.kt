package com.pushpak.mealz.ui.meal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pushpak.mealz.model.MealsCategory
import com.pushpak.mealz.model.MealsCategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel(private val mealRepository: MealRepository = MealRepository()) : ViewModel() {

    var meals by mutableStateOf(emptyList<MealsCategory>())
    init {
        viewModelScope.launch (Dispatchers.IO){
            meals = getMeals()
        }
    }
   suspend fun getMeals() : List<MealsCategory> {
       return mealRepository.getMeals().categories
    }
}