package com.pushpak.mealz.ui.meal

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MealScreen() {
    val mealViewModel: MealViewModel = viewModel()
    val getMeals = mealViewModel.getMeals()
}