package com.soopeach.conviwizard.data.datasource

interface AccountDatasource {

    suspend fun getUid(): String?

    suspend fun updateUid(uid: String)
}