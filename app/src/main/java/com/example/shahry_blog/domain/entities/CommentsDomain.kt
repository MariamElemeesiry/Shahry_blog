package com.example.shahry_blog.domain.entities

import java.time.OffsetDateTime


data class CommentsDomain(
    val id: Long,
    val date: OffsetDateTime,
    val userName: String?,
    val body: String?,
    val email: String?,
    val avatarUrl: String?
)
