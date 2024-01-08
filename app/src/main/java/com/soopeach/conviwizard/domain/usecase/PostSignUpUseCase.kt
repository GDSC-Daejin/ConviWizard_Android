package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.model.SignUpRequest
import com.soopeach.conviwizard.domain.repository.AccountRepository

class PostSignUpUseCase(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(signUpRequest: SignUpRequest): String {
        return accountRepository.postSignUpRequest(signUpRequest)
    }
}