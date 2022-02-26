package com.example.shahry_blog.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.OffsetDateTime

@Parcelize
data class Articles(
    val id: Long,
    val date: OffsetDateTime,
    val title: String?,
    val body: String?,
    val imageUrl: String?,
    val authorId: Long
) : Parcelable
