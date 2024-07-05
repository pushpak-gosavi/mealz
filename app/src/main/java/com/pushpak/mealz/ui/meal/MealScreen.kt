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
    var response by remember {
        mutableStateOf(emptyList<MealsCategory>())
    }
    val remberScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "GET_Meal"){
        remberScope.launch(Dispatchers.IO){
            response = mealViewModel.getMeals()
        }
    }
    LazyColumn(content = {
        items(response) {
            Text(text = it.name)
        }
    })
}


