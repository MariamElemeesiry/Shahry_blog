package com.example.shahry_blog.domain.entities

import com.example.shahry_blog.presentation.models.Articles
import java.time.OffsetDateTime

data class PostsDomain(
    val id: Long,
    val date: OffsetDateTime,
    val title: String?,
    val body: String?,
    val imageUrl: String?,
    val authorId: Long
)

fun PostsDomain.mapToDomain(): Articles = Articles(
    id = id,
    date = date,
    title = title,
    body = body,
    imageUrl = imageUrl,
    authorId = authorId
)
