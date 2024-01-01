package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit) {
    BasicTextField(value = value, onValueChange = { onValueChange(it) })
    { innerTextField ->

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (value.isEmpty()) {
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
}