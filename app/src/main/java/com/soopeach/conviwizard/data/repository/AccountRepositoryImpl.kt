package com.soopeach.conviwizard.data.repository

import com.soopeach.conviwizard.data.datasource.AccountDatasource
import com.soopeach.conviwizard.domain.repository.AccountRepository

class AccountRepositoryImpl(
    private val accountDatasource: AccountDatasource
): AccountRepository {
    override suspend fun getUid(): String? {
        return accountDatasource.getUid()
    }

    override suspend fun updateUid(uid: String) {
        accountDatasource.updateUid(uid)
    }
}