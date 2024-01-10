package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.domain.model.post.PostRequest
import com.soopeach.conviwizard.domain.model.post.PostResponse
import com.soopeach.conviwizard.domain.usecase.GetUidUseCase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import java.io.File
import java.nio.file.Files

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

    override suspend fun postPost(postRequest: PostRequest, file: File): Boolean {

        val httpResponse = client.submitFormWithBinaryData(
            url = "board/insert",
            formData = formData {
                append("board", """
                    { "boardName": "${postRequest.boardName}",
                     "boardContent": "${postRequest.boardContent}",
                      "boardCookingtime": "${postRequest.boardCookingtime}",
                       "boardCookinglevel": ${postRequest.boardCookinglevel},
                        "boardTotalprice": ${postRequest.boardTotalprice},
                         "productId": ${postRequest.productId},
                          "categoryId": ${postRequest.categoryId}
                         }
               """.trimIndent(),
                    Headers.build {
                        append(HttpHeaders.ContentType, "application/json")
                    })
                append("file", file.readBytes(), Headers.build {
                    append(HttpHeaders.ContentType, Files.probeContentType(file.toPath()))
                    append(HttpHeaders.ContentDisposition, "filename=${file.name}")
                })
            }
        ) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HttpHeaders.Cookie, "JSESSIONID=${getUidUseCase()}")
        }

        return httpResponse.body<String>().contains("Ok")
    }
}