package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RecommendedItem() {
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color(0xFFEAEAEA))
            .padding(vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(20.dp))
                    .height(120.dp),
                model = "https://picsum.photos/300", contentDescription = "조합 사진",
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "롯데리아노예님의\n오감자 치즈 후라이")

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "조리 시간 : 10분")
                Text(text = "난이도 : 4")
                Text(text = "가격 : 8700원")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(35.dp)
                            .clip(RoundedCornerShape(50.dp)),
                        model = "https://picsum.photos/300", contentDescription = "프로필 사진",
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "롯데리아노예")
                }

                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "좋아요 아이콘")
            }
        }
    }
}