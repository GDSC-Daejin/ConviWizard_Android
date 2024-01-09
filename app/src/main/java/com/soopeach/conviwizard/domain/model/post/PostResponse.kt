package com.soopeach.conviwizard.domain.model.post

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val boardContent: String,
    val boardCookinglevel: Int,
    val boardCookingtime: String,
    val boardId: Int,
    val boardImage: String,
    val boardLikecount: Int,
    val boardName: String,
    val boardTotalprice: Int,
    val categoryId: Int,
    val memberId: String,
    val productId: Int
)