package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.data.ConviWizardDataStore
import com.soopeach.conviwizard.domain.model.SignUpRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.Parameters
import kotlinx.coroutines.flow.first

class AccountDatasourceImpl(
    private val dataStore: ConviWizardDataStore,
    private val client: HttpClient
) : AccountDatasource {
    override suspend fun getUid(): String? {
        return dataStore.uId.first()
    }

    override suspend fun updateUid(uid: String) {
        dataStore.updateUId(uid)
    }

    override suspend fun postSignUpRequest(signUpRequest: SignUpRequest): String {
        val httpResult = client.post("signin") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(signUpRequest)
        }

        val result = httpResult.body<String>()
        return result
    }

    override suspend fun requestLogin(memberId: String, password: String): String {

        val httpResponse = client.submitForm(
            url = "login",
            formParameters = Parameters.build {
                append("memberId", memberId)
                append("password", password)
            }
        )

        val redirect = httpResponse.headers["Location"]

        return if (redirect != null && redirect.contains("Success")) {
            val redirectedHttpResponse = client.get(redirect)
            redirectedHttpResponse.body<String>().split(" : ")[1]
        } else {
            "Failed"
        }
    }
}