package com.soopeach.conviwizard.ui.screen.like

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.Divider
import com.soopeach.conviwizard.ui.components.LikeItem

@Composable
fun LikeScreen(
    navController: NavHostController,
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {


        item {
            Spacer(modifier = Modifier.padding(12.dp))

            Divider(
                color = Color.Gray,
                size = 3
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Today 1/7",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(12.dp))
        }

        repeat(10) {
            item {
                LikeItem()
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }


    }
}