package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.repository.AccountRepository

class GetUidUseCase(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(): String? {
        return accountRepository.getUid()
    }
}