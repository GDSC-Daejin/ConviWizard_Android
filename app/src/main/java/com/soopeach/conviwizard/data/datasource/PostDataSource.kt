package com.soopeach.conviwizard.data.datasource

import com.soopeach.conviwizard.domain.model.post.PostResponse

interface PostDataSource {

    suspend fun getPosts(category: Long?): List<PostResponse>
}