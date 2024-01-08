package com.soopeach.conviwizard.viewmodel

import androidx.lifecycle.ViewModel
import com.soopeach.conviwizard.domain.model.SignUpRequest
import com.soopeach.conviwizard.domain.usecase.PostSignUpUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

sealed class SignUpScreenSideEffect {
    data object RegisterSuccess : SignUpScreenSideEffect()
}

data class SignUpScreenState(
    val dummy : String = ""
)

class SignUpScreenViewModel(
    private val postSignUpUseCase: PostSignUpUseCase
) : ViewModel(), ContainerHost<SignUpScreenState, SignUpScreenSideEffect> {

    override val container: Container<SignUpScreenState, SignUpScreenSideEffect> =
        container(SignUpScreenState())

    fun postSignUpRequest(
        memberEmail: String,
        memberId: String,
        memberName: String,
        memberNickname: String,
        memberPassword: String,
        memberPhonenumber: String
    ) = intent {
        val result = postSignUpUseCase(
            SignUpRequest(
                memberEmail,
                memberId,
                memberName,
                memberNickname,
                memberPassword,
                memberPhonenumber
            )
        )

        postSideEffect(SignUpScreenSideEffect.RegisterSuccess)

    }

}