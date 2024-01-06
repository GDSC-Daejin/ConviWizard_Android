package com.soopeach.conviwizard.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.BasicInputTextForm

@Composable
fun WriteScreen(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "조합 이름",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var combinationName by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = combinationName, hint = "조합의 이름을 알려주세요."
        ) {
            combinationName = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 방법",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var combinationContent by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = combinationContent, hint = "조합을 만드는 방법을 알려주세요."
        ) {
            combinationContent = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 시간",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var cookingTime by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = cookingTime, hint = "조합을 만드는데 걸리는 시간(분)을 알려주세요."
        ) {
            cookingTime = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 난이도",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var cookingLevel by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = cookingLevel, hint = "조합의 난이도를 알려주세요."
        ) {
            cookingLevel = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 비용",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var totalPrice by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = totalPrice, hint = "조합의 비용을 알려주세요."
        ) {
            totalPrice = it
        }

        Spacer(modifier = Modifier.padding(24.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF74C5F7),
                    contentColor = Color.Black
                ),
                onClick = {

                }) {
                Text(
                    text = "조합 등록하기",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

