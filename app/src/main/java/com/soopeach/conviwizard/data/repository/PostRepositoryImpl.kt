package com.soopeach.conviwizard.data.repository

import com.soopeach.conviwizard.data.datasource.PostDataSource
import com.soopeach.conviwizard.domain.model.post.PostRequest
import com.soopeach.conviwizard.domain.model.post.PostResponse
import com.soopeach.conviwizard.domain.repository.PostRepository
import java.io.File

class PostRepositoryImpl(
    private val postDataSource: PostDataSource
): PostRepository {
    override suspend fun getPosts(category: Long?): List<PostResponse> {
        return postDataSource.getPosts(category)
    }

    override suspend fun postPost(postRequest: PostRequest, file: File): Boolean {
        return postDataSource.postPost(postRequest, file)
    }
}