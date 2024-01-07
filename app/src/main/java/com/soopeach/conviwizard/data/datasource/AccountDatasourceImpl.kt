package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.data.ConviWizardDataStore
import kotlinx.coroutines.flow.first

class AccountDatasourceImpl(
    private val dataStore: ConviWizardDataStore
): AccountDatasource {
    override suspend fun getUid(): String? {
        return dataStore.uId.first()
    }

    override suspend fun updateUid(uid: String) {
        dataStore.updateUId(uid)
    }
}