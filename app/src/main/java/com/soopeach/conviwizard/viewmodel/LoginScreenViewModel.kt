package com.soopeach.conviwizard.viewmodel

import androidx.lifecycle.ViewModel
import com.soopeach.conviwizard.domain.usecase.RequestLoginUseCase
import com.soopeach.conviwizard.domain.usecase.UpdateUidUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

sealed class LoginScreenSideEffect {
    data object LoginSuccess : LoginScreenSideEffect()
    data object LoginFailure : LoginScreenSideEffect()
}

data class LoginScreenState(
    val dummy: String = ""
)

class LoginScreenViewModel(
    private val requestLoginUseCase: RequestLoginUseCase,
    private val updateUidUseCase: UpdateUidUseCase
) : ViewModel(), ContainerHost<LoginScreenState, LoginScreenSideEffect> {

    override val container: Container<LoginScreenState, LoginScreenSideEffect> =
        container(LoginScreenState())

    fun requestLogin(email: String, password: String) = intent {
        val result = requestLoginUseCase(email, password)

        if (result != "Failed") {
            updateUidUseCase(result)
            postSideEffect(LoginScreenSideEffect.LoginSuccess)
        } else {
            postSideEffect(LoginScreenSideEffect.LoginFailure)
        }

    }
}