package com.example.shahry_blog.domain.entities

import androidx.paging.PagingData
import androidx.paging.map
import com.example.shahry_blog.presentation.models.Articles
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.OffsetDateTime

data class PostsDomain(
    val id: Long,
    val date: OffsetDateTime,
    val title: String?,
    val body: String?,
    val imageUrl: String?,
    val authorId: Long
)

fun PostsDomain.mapToPresentation(): Articles = Articles(
    id = id,
    date = date,
    title = title,
    body = body,
    imageUrl = imageUrl,
    authorId = authorId
)


fun Flow<PagingData<PostsDomain>>.mapToPresentation() =
    map { it.map { it.mapToPresentation() } }

