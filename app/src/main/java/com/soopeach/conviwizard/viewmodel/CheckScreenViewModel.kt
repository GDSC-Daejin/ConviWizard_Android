package com.soopeach.conviwizard.viewmodel

import androidx.lifecycle.ViewModel
import com.soopeach.conviwizard.domain.model.UiState
import com.soopeach.conviwizard.domain.usecase.GetUidUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

sealed class CheckScreenSideEffect {

}

data class CheckScreenState(
    val uid: UiState<String> = UiState.Idle
)

class CheckScreenViewModel(
    private val getUidUseCase: GetUidUseCase,
): ViewModel(), ContainerHost<CheckScreenState, CheckScreenSideEffect> {

    override val container: Container<CheckScreenState, CheckScreenSideEffect>
        = container(CheckScreenState())

    fun getUid() = intent {
        val uid = getUidUseCase()

        reduce {
            if (uid == null) {
                state.copy(uid = UiState.Loading)
            } else {
                state.copy(uid = UiState.Success(uid))
            }
        }
    }
}