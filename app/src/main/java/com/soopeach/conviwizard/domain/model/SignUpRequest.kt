package com.soopeach.conviwizard.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val memberEmail: String,
    val memberId: String,
    val memberName: String,
    val memberNickname: String,
    val memberPassword: String,
    val memberPhonenumber: String
)