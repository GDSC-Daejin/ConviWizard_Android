package com.soopeach.conviwizard.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.viewmodel.CheckScreenViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CheckScreen(
    navController: NavHostController,
) {

    val viewModel = koinViewModel<CheckScreenViewModel>()
    val state by viewModel.collectAsState()

    state.uid.getDataOrNull()?.let {
        navController.navigate(Screen.Home.route)
    } ?: run {
        navController.navigate(Screen.Login.route)
    }

}