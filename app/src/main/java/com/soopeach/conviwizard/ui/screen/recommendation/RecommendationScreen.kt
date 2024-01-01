package com.soopeach.conviwizard.ui.screen.recommendation

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.soopeach.conviwizard.ui.components.RecommendedItem
import com.soopeach.conviwizard.ui.components.RecommendedKeywordChip
import com.soopeach.conviwizard.ui.components.SearchBar

@Composable
fun RecommendationScreen(
    navController: NavHostController,
) {
    LazyColumn(
        modifier = androidx.compose.ui.Modifier
            .padding(horizontal = 12.dp)
    ) {

        item {
            Spacer(modifier = androidx.compose.ui.Modifier.padding(vertical = 20.dp))
        }

        item {
            var query by remember { mutableStateOf("") }
            SearchBar(query, onValueChange = {
                query = it
            })
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val categoryKeywords = listOf("국물류", "간식/스낵류", "음료/주류")
                categoryKeywords.forEach { keyword ->
                    RecommendedKeywordChip(keyword)
                }
            }
        }

        items((0..10).toList()) {
            RecommendedItem()
        }
    }
}