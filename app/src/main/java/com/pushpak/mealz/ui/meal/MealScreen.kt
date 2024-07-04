package com.pushpak.mealz.ui.meal

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pushpak.mealz.model.MealsCategory

@Composable
fun MealScreen() {
    val mealViewModel: MealViewModel = viewModel()
    var response by remember {
        mutableStateOf(emptyList<MealsCategory>())
    }

    mealViewModel.getMeals { mealsCategoryResponse ->

        mealsCategoryResponse?.categories.let { response = it!! }

    }

    LazyColumn(content = {
        items(response) {
            Text(text = it.name)
        }
    })
}


