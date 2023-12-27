package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MyRecipeItem() {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(152.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(1f),
            model = "https://picsum.photos/300",
            contentDescription = "Combination Image",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "레시피 설명")

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        model = "https://picsum.photos/300",
                        contentDescription = "Combination Image",
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(68.dp)
                .background(Color(0xFFDC143C))
                .clickable {

                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "삭제")
        }
    }
}