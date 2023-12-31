package com.soopeach.conviwizard.ui.screen.search

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.RecommendedKeywordChip

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 32.dp)
    ) {

        Text(text = "상품을 검색해 보세요.")

        Spacer(modifier = Modifier.height(16.dp))

        var query by remember { mutableStateOf("") }
        BasicTextField(value = query, onValueChange = { query = it })
        { innerTextField ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                if (query.isEmpty()) {
                    Box {
                        Text(text = "검색어를 입력해주세요.")
                        innerTextField()
                    }
                } else {
                    innerTextField()
                }


                Icon(imageVector = Icons.Filled.Search, contentDescription = "검색 아이콘")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "추천 검색어")

        Spacer(modifier = Modifier.height(16.dp))

        val recommendedKeywords = listOf("불닭", "바나나 우유", "오징어집", "스윙칩", "코코볼")

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            recommendedKeywords.forEach { keyword ->
                RecommendedKeywordChip(text = keyword)
            }
        }

    }
}