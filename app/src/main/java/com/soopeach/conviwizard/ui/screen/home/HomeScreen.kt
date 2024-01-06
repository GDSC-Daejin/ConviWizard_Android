package com.soopeach.conviwizard.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.R
import com.soopeach.conviwizard.ui.components.CombinationRow
import com.soopeach.conviwizard.ui.screen.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
) {

    val bannerItemList = (1..5).toList()
    val pagerState = rememberPagerState(pageCount = { bannerItemList.size })

    LazyColumn {
        item {
            HorizontalPager(
                state = pagerState
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color(0xFF74BDE9)),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(text = "배너 ${pagerState.currentPage}")
                }
            }
        }

        val recentItemList = (1..100).toList()

        item {
            CombinationRow(
                rowTitle = "최근 등록된 조합",
                itemList = recentItemList,
            ) {
                navController.navigate("detail/$it")
            }
        }

        val popularItemList = (1..100).toList()

        item {
            CombinationRow(
                rowTitle = "인기 조합",
                itemList = popularItemList,
            ) {
                navController.navigate("detail/$it")
            }
        }

        val recommendationItemList = (1..100).toList()

        item {
            CombinationRow(
                rowTitle = "추천 조합",
                itemList = recommendationItemList,
            ) {
                navController.navigate("detail/$it")
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                FloatingActionButton(onClick = { navController.navigate(Screen.Write.route) }) {
                    Image(
                        painter = painterResource(id = R.drawable.pencil),
                        contentDescription = "글쓰기 버튼"
                    )
                }
            }
        }
    }
}