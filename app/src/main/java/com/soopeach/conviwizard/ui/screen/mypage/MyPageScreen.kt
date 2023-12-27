package com.soopeach.conviwizard.ui.screen.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.soopeach.conviwizard.ui.components.MyRecipeItem

@Composable
fun MyPageScreen(
    navController: NavHostController,
) {

    LazyColumn {
        item {

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0xFFEEE6C4)),
                contentAlignment = androidx.compose.ui.Alignment.Center

            ) {
                Column(
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape),
                        model = "https://picsum.photos/200",
                        contentDescription = "Combination Image"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "이름",
                    )
                }
            }
        }

        item {

            Column(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "나의 레시피",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "3",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        val recipeList = (1..10).toList()

        items(recipeList.size) {

            MyRecipeItem()

            Spacer(modifier = Modifier.height(12.dp))
        }

    }
}