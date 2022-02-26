package com.example.shahry_blog.domain.entities

import com.example.shahry_blog.helpers.getTimeAgo
import com.example.shahry_blog.presentation.models.Comments
import java.time.OffsetDateTime


data class CommentsDomain(
    val id: Long,
    val date: OffsetDateTime,
    val userName: String?,
    val body: String?,
    val email: String?,
    val avatarUrl: String?
)

fun CommentsDomain.mapToPresentation(): Comments = Comments(
    id = id,
    userName = userName,
    date = getTimeAgo(date)!!,
    body = body,
    email = email,
    avatarUrl = avatarUrl
)
