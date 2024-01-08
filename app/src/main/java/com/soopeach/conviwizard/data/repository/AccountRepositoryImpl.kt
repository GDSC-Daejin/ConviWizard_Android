package com.soopeach.conviwizard.data.repository

import com.soopeach.conviwizard.data.datasource.AccountDatasource
import com.soopeach.conviwizard.domain.model.SignUpRequest
import com.soopeach.conviwizard.domain.repository.AccountRepository

class AccountRepositoryImpl(
    private val accountDatasource: AccountDatasource
) : AccountRepository {
    override suspend fun getUid(): String? {
        return accountDatasource.getUid()
    }

    override suspend fun updateUid(uid: String) {
        accountDatasource.updateUid(uid)
    }

    override suspend fun postSignUpRequest(signUpRequest: SignUpRequest): String {
        return accountDatasource.postSignUpRequest(signUpRequest)
    }
}