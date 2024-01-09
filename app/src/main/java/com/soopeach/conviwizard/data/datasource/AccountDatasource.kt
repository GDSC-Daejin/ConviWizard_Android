package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.domain.model.SignUpRequest

interface AccountDatasource {

    suspend fun getUid(): String?

    suspend fun updateUid(uid: String)

    suspend fun postSignUpRequest(signUpRequest: SignUpRequest): String

    suspend fun requestLogin(memberId: String, password: String): String
}