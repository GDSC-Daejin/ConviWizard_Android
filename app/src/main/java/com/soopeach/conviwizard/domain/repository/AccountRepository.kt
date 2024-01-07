package com.soopeach.conviwizard.domain.repository

interface AccountRepository {

    suspend fun getUid(): String?

    suspend fun updateUid(uid: String)
}