package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.domain.model.post.PostResponse
import com.soopeach.conviwizard.domain.usecase.GetUidUseCase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

class PostDataSourceImpl(
    private val client: HttpClient,
    private val getUidUseCase: GetUidUseCase
) : PostDataSource {
    override suspend fun getPosts(category: Long?): List<PostResponse> {
        val httpResponse = client.get(
            "board/search/${category ?: "all"}"
        ) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HttpHeaders.Cookie, "JSESSIONID=${getUidUseCase()}")
        }

        return httpResponse.body<List<PostResponse>>()
    }
}