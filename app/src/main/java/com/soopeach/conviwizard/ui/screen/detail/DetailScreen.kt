package com.soopeach.conviwizard.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.soopeach.conviwizard.R
import com.soopeach.conviwizard.ui.components.Divider

@Composable
fun DetailScreen(
    navController: NavHostController,
) {

    LazyColumn {

        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = "https://picsum.photos/200", contentDescription = "Combination Image"
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF3FDC87)),
                contentAlignment = androidx.compose.ui.Alignment.CenterEnd
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(36.dp)
                        .clickable {

                        },
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "좋아요 버튼",
                )
            }
        }

        item {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "작성자"
            )
            Divider()
        }

        item {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "재료"
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {

                val ingredientList = (1..10).toList()

                items(ingredientList.size) {
                    AsyncImage(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .size(80.dp),
                        model = "https://picsum.photos/200",
                        contentDescription = "Ingredient Image"
                    )

                    Spacer(modifier = Modifier.width(12.dp))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider()
        }

        item {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "댓글"
            )
        }

        val commentItemList = (1..100).toList()

        items(commentItemList.size) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                text = "댓글 ${it + 1}번째"
            )
        }

    }
}