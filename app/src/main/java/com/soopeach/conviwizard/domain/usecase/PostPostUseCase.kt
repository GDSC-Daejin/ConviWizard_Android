package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.model.post.PostRequest
import com.soopeach.conviwizard.domain.repository.PostRepository
import java.io.File

class PostPostUseCase(
    private val postRepository: PostRepository
) {

    suspend operator fun invoke(postRequest: PostRequest, file: File): Boolean =
        postRepository.postPost(postRequest, file)
}