package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SmallCombinationItem(
    imageUrl: String = "https://picsum.photos/200",
    combinationName: String,
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(12.dp))
                .size(80.dp),
            model = imageUrl, contentDescription = "Combination Image"
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = combinationName,
            textAlign = TextAlign.Center,
        )
    }
}