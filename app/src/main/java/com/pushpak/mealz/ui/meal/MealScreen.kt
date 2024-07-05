package com.pushpak.mealz.ui.meal

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pushpak.mealz.model.MealsCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MealScreen() {
    val mealViewModel: MealViewModel = viewModel()
    val meals = mealViewModel.meals

    LazyColumn(content = {
        items(meals) {
            Text(text = it.name)
        }
    })
}


