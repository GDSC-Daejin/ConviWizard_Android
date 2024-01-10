package com.soopeach.conviwizard.domain.model.post

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val boardContent: String,
    val boardCookinglevel: Int,
    val boardCookingtime: String,
    val boardName: String,
    val boardTotalprice: Int,
    val categoryId: Int,
    val productId: Int
)