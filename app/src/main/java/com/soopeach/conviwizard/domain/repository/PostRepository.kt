package com.soopeach.conviwizard.domain.repository

import com.soopeach.conviwizard.domain.model.post.PostRequest
import com.soopeach.conviwizard.domain.model.post.PostResponse
import java.io.File

interface PostRepository {

    suspend fun getPosts(category: Long?): List<PostResponse>

    suspend fun postPost(postRequest: PostRequest, file: File): Boolean
}