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
import androidx.compose.ui.unit.dp

@Composable
fun <T> CombinationRow(
    rowTitle: String,
    itemList: List<T>,
    onItemClicked: (Long) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Text(text = rowTitle)

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