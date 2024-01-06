package com.soopeach.conviwizard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicInputTextForm(
    modifier: Modifier = Modifier,
    value: String,
    hint: String = "",
    onValueChange: (String) -> Unit
) {

    BasicTextField(
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color.LightGray.copy(alpha = 0.8f))
            .padding(16.dp),
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        textStyle = TextStyle.Default.copy(
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    )
    { innerTextField ->
        Box(
        ) {
            innerTextField()
            if (value.isEmpty()) {
                Text(
                    text = hint,
                    style = TextStyle.Default.copy(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}