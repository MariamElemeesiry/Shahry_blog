package com.example.shahry_blog.presentation.models

import java.time.OffsetDateTime


data class Comments(
    val id: Long,
    val date: OffsetDateTime,
    val userName: String?,
    val body: String?,
    val email: String?,
    val avatarUrl: String?
)
