package com.soopeach.conviwizard.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.soopeach.conviwizard.ui.screen.recommendation.RecommendationScreen
import com.soopeach.conviwizard.ui.screen.Screen.Companion.bottomNavigationItems
import com.soopeach.conviwizard.ui.screen.detail.DetailScreen
import com.soopeach.conviwizard.ui.screen.home.HomeScreen
import com.soopeach.conviwizard.ui.screen.like.LikeScreen
import com.soopeach.conviwizard.ui.screen.mypage.MyPageScreen

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    AppScreenContent(navController)
}

@Composable
fun AppScreenContent(
    navController: NavHostController,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            AnimatedVisibility(
                visible = currentDestination?.route in bottomNavigationItems.map { it.route },
                enter = slideInVertically(initialOffsetY = {
                    it
                }),
                exit = slideOutVertically(targetOffsetY = {
                    it
                })
            )
            {
                BottomNavigation(
                    modifier = Modifier.clip(
                        shape = RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                        )
                    ),
                    elevation = 10.dp,
                    backgroundColor = MaterialTheme.colorScheme.surface,
                ) {
                    bottomNavigationItems.forEach { screen ->
                        val selected =
                            currentDestination?.hierarchy?.any { it.route == screen.route } == true

                        Column(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                                .weight(1f)
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Icon(
                                imageVector = if (selected) requireNotNull(screen.selectedIconImageVector)
                                else requireNotNull(screen.unSelectedIconImageVector),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(if (selected) 24.dp else 20.dp),
                            )
                        }
                    }
                }
            }

        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding),
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(
                Screen.Detail.route,
                Screen.Detail.arguments
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                val postId = arguments.getLong("postId", -1L)
                DetailScreen(navController, postId)
            }

            composable(Screen.Recommendation.route) {
                RecommendationScreen(navController)
            }

            composable(Screen.Like.route) {
                LikeScreen(navController)
            }

            composable(Screen.MyPage.route) {
                MyPageScreen(navController)
            }
        }
    }
}