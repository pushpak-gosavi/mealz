package com.pushpak.mealz.ui.meal

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pushpak.mealz.model.MealsCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.annotation.ElementType

@Composable
fun MealScreen() {
    val mealViewModel: MealViewModel = viewModel()
    val meals = mealViewModel.meals

    LazyColumn(
        contentPadding = PaddingValues(top = 10.dp),
        content = {
            items(meals) { meal ->
                MealCard(mealsCategory = meal)
            }
        })
}

@Composable
fun MealCard(mealsCategory: MealsCategory) {
    Card(
        modifier = Modifier.padding(top = 16.dp, start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier.size(88.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mealsCategory.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = mealsCategory.description
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 5.dp)
                    .align(Alignment.CenterVertically),
            ) {
                Text(text = mealsCategory.name)
            }

        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun PreviewMealItem(){
    val mealsCategory = MealsCategory(
        id = "123",
        name = "Dhokla",
        description = "Hello World",
        imageUrl = "https://www.themealdb.com/images/category/beef.png"
    )
    MealCard(mealsCategory)
}


