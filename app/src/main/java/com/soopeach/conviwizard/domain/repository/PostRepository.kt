package com.soopeach.conviwizard.domain.repository

import com.soopeach.conviwizard.domain.model.post.PostResponse

interface PostRepository {

    suspend fun getPosts(category: Long?): List<PostResponse>
}