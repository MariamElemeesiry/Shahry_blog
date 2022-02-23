package com.example.shahry_blog.domain.entities

import java.time.OffsetDateTime

data class PostsDomain(
    val id: Long,
    val date: OffsetDateTime,
    val title: String?,
    val body: String?,
    val imageUrl: String?,
    val author:AuthorDomain?,
    val commentsList: List<CommentsDomain>
)
