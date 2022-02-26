package com.example.shahry_blog.presentation.models

import java.time.OffsetDateTime

data class Articles(
    val id: Long,
    val date: OffsetDateTime,
    val title: String?,
    val body: String?,
    val imageUrl: String?,
    val authorId: Long
)
