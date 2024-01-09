package com.soopeach.conviwizard.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.domain.model.UiState
import com.soopeach.conviwizard.viewmodel.CheckScreenViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CheckScreen(
    navController: NavHostController,
) {

    val viewModel = koinViewModel<CheckScreenViewModel>()
    val state by viewModel.collectAsState()

    LaunchedEffect(true) {
        viewModel.getUid()
    }

    when(state.uid) {
        is UiState.Idle -> {

        }
        is UiState.Loading -> {
            navController.navigate(Screen.Login.route)
        }
        is UiState.Success -> {
            navController.navigate(Screen.Home.route)
        }
        is UiState.Error -> {

        }
    }

}