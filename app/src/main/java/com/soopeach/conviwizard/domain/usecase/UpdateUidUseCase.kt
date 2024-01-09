package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.repository.AccountRepository

class UpdateUidUseCase(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(uid: String) {
        accountRepository.updateUid(uid)
    }
}