package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun <T> CombinationRow(
    rowTitle: String,
    itemList: List<T>,
    onItemClicked: (Long) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
    ) {

        Text(text = rowTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
        ) {
            items(itemList.size) {
                SmallCombinationItem("https://picsum.photos/200", "조합 이름") {
                    onItemClicked(it)
                }
            }
        }
    }
}