package com.soopeach.conviwizard.domain.usecase

import com.soopeach.conviwizard.domain.repository.PostRepository

class GetPostsUseCase(
    private val postRepository: PostRepository
) {

    suspend operator fun invoke(category: Long) = postRepository.getPosts(category)
}