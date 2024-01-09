package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.repository.AccountRepository

class RequestLoginUseCase(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(memberId: String, password: String): String {
        return accountRepository.requestLogin(memberId, password)
    }
}