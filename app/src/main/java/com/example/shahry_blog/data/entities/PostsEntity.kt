package com.example.shahry_blog.data.entities

import androidx.paging.PagingData
import androidx.paging.map
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shahry_blog.data.type_converters.OffsetDateTimeTypeConverter
import com.example.shahry_blog.domain.entities.PostsDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Entity(tableName = "posts")
data class PostsEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?,
    @ColumnInfo(name = "authorId") val authorId: Long
)

fun PostsEntity.mapToDomain(): PostsDomain = PostsDomain(
    id = id,
    date = OffsetDateTimeTypeConverter.toOffsetDateTime(date)!!,
    title = title,
    body = body,
    imageUrl = imageUrl,
    authorId = authorId
)

fun List<PostsEntity>.mapToDomain(): List<PostsDomain> = map { it.mapToDomain() }


fun Flow<PagingData<PostsEntity>>.mapToDomain() =
    map { it.map { it.mapToDomain() } }
